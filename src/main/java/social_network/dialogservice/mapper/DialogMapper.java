package social_network.dialogservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import social_network.dialogservice.dto.AccountDto;
import social_network.dialogservice.dto.DialogDto;
import social_network.dialogservice.dto.MessageDto;
import social_network.dialogservice.model.DialogEntity;

@Mapper(componentModel = "spring")
public interface DialogMapper {

    //@Mapping ???
    DialogDto toDto(DialogEntity dialogEntity, MessageDto lastMessage, Long unreadCount);

    DialogEntity toEntity(DialogDto dialogDto);
}
