package social_network.dialogservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import social_network.dialogservice.dto.DialogDto;
import social_network.dialogservice.dto.MessageDto;
import social_network.dialogservice.model.Dialog;

@Mapper(componentModel = "spring")
public interface DialogMapper {

    @Mapping(target = "id", source = "dialog.id")
    @Mapping(target = "lastMessage", ignore = true)
    DialogDto toDto(Dialog dialog, Long conversationPartner, MessageDto lastMessage, Long unreadCount);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorId", source = "id")
    @Mapping(target = "recipientId", source = "id")
    @Mapping(target = "unreadCountAuthor", source = "unreadCount")
    @Mapping(target = "unreadCountRecipient", source = "unreadCount")
    @Mapping(target = "lastMessage", ignore = true)
    @Mapping(target = "messages", ignore = true)
    Dialog toEntity(DialogDto dialogDto);
}
