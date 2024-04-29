package social_network.dialogservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import social_network.dialogservice.dto.*;
import social_network.dialogservice.dto.response.GetDialogsRs;
import social_network.dialogservice.dto.response.GetMessagesRs;
import social_network.dialogservice.dto.response.SetStatusMessageReadRs;
import social_network.dialogservice.dto.response.UnreadCountRs;
import social_network.dialogservice.mapper.DialogMapper;
import social_network.dialogservice.mapper.MessageMapper;
import social_network.dialogservice.model.DialogEntity;
import social_network.dialogservice.model.MessageEntity;
import social_network.dialogservice.repository.DialogRepository;
import social_network.dialogservice.repository.MessageRepository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DialogServiceImpl implements DialogService{

    private final DialogRepository dialogRepository;
    private final MessageRepository messageRepository;
    private final DialogMapper dialogMapper;
    private final MessageMapper messageMapper;

    @Override
    public GetDialogsRs getAllDialogs(Integer offset, Integer itemPerPage) {

        Long userId = 0L; // где взять userId?
        GetDialogsRs response = new GetDialogsRs();
        PageRequest request = PageRequest.of(offset, itemPerPage);

        List<DialogDto> data = dialogRepository
                .findAllByAuthorIdOrRecipientIdOrderByLastMessageDesc(userId, userId, request)
                .map(dialog -> {

//                    Long conversationPartner = dialog.getAuthorId().equals(userId) ?
//                            dialog.getRecipientId() : dialog.getAuthorId();

                    MessageEntity message = dialog.getMessages().stream()
                            .max(Comparator.comparing(MessageEntity::getId)).orElse(null);
                    if (message == null) {
                        return dialogMapper.toDto(dialog, new MessageDto(), 0L);
                    }

                    MessageDto lastMessage = messageMapper.toDto(message);
                    Long recipientId = lastMessage.getAuthorId().equals(dialog.getAuthorId()) ?
                            dialog.getRecipientId() : dialog.getAuthorId();
                    lastMessage.setRecipientId(recipientId);

                    Long unreadCount = dialog.getAuthorId().equals(userId) ?
                            dialog.getUnreadCountAuthor() : dialog.getUnreadCountRecipient();

                    return dialogMapper.toDto(dialog, lastMessage, unreadCount);

                }).getContent();

        response.setTimestamp(ZonedDateTime.now().toEpochSecond());
        response.setTotal(data.size());
        response.setOffset(offset);
        response.setPerPage(itemPerPage);
        response.setCurrentUserId(userId);
        response.setData(data);

        return response;
    }

    @Override
    public GetMessagesRs getAllMessages(Long companionId, Integer offset, Integer itemPerPage) {

        Long userId = 0L; // где взять userId?

        GetMessagesRs response = new GetMessagesRs();
        DialogEntity dialog = dialogRepository.findByAuthorIdAndRecipientId(userId, companionId);

        if (dialog == null) {
            dialog = new DialogEntity();
            dialog.setAuthorId(userId);
            dialog.setRecipientId(companionId);
            dialog.setUnreadCountAuthor(0L);
            dialog.setUnreadCountRecipient(0L);
            dialogRepository.save(dialog);

            response.setTimestamp(ZonedDateTime.now().toEpochSecond());
            response.setTotal(0);
            response.setOffset(offset);
            response.setPerPage(itemPerPage);
            response.setData(new ArrayList<>());

            return response;
        }

        PageRequest request = PageRequest.of(offset, itemPerPage);
        final Long[] readCount = {0L};
        List<MessageShortDto> data = messageRepository
                .findMessageEntitiesByDialogIdOrderByTimeDesc(dialog.getId(), request)
                .map(message -> {
                    if (message.getReadStatus().equals("SENT") && !message.getAuthorId().equals(userId)) {
                        message.setReadStatus("READ");
                        readCount[0]++;
                    }
                    return messageMapper.toShortDto(message);
                }).getContent();

        if (dialog.getAuthorId().equals(userId)) {
            dialog.setUnreadCountAuthor(dialog.getUnreadCountAuthor() - readCount[0]);
        } else {
            dialog.setUnreadCountRecipient(dialog.getUnreadCountRecipient() - readCount[0]);
        }

        response.setTimestamp(ZonedDateTime.now().toEpochSecond());
        response.setTotal(data.size());
        response.setOffset(offset);
        response.setPerPage(itemPerPage);
        response.setData(data);

        return response;
    }

    @Override
    public UnreadCountRs getUnreadMessageCount() {

        Long userId = 0L; // где взять userId?
        UnreadCountRs response = new UnreadCountRs();

        Long unreadCount = dialogRepository.findAllByAuthorIdOrAllRecipientId(userId, userId)
                .stream()
                .map(dialogEntity -> dialogEntity.getAuthorId().equals(userId) ?
                        dialogEntity.getUnreadCountAuthor() : dialogEntity.getUnreadCountRecipient())
                .collect(Collectors.summarizingLong(Long::longValue)).getSum();

        response.setTimestamp(ZonedDateTime.now().toEpochSecond());
        response.setData(new UnreadCountDto(unreadCount));

        return response;
    }

    @Override
    public SetStatusMessageReadRs setStatusMessageRead(Long companionId) {

        getAllMessages(companionId, 0, 100);
        SetStatusMessageReadRs response = new SetStatusMessageReadRs();
        response.setTimestamp(ZonedDateTime.now().toEpochSecond());
        response.setData(new SetStatusMessageReadDto("OK"));

        return response;
    }
}
