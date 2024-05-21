package social_network.dialogservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import social_network.dialogservice.dto.DialogMessageDto;
import social_network.dialogservice.dto.MessageDto;
import social_network.dialogservice.dto.MessageShortDto;
import social_network.dialogservice.model.Dialog;
import social_network.dialogservice.model.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    @Mapping(target = "status", source = "readStatus")
    @Mapping(target = "recipientId", source = "dialogId.recipientId")
    MessageDto toDto(Message message);

    MessageShortDto toShortDto(Message message);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "readStatus", constant = "SENT")
    @Mapping(target = "dialogId", source = "dialog")
    @Mapping(target = "authorId", source = "dialogMessageDto.authorId")
    Message toEntity(DialogMessageDto dialogMessageDto, Dialog dialog);
}
