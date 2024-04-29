package social_network.dialogservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import social_network.dialogservice.dto.MessageDto;
import social_network.dialogservice.dto.MessageShortDto;
import social_network.dialogservice.model.MessageEntity;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    //@Mapping(???)
    MessageDto toDto(MessageEntity messageEntity);

    MessageShortDto toShortDto(MessageEntity messageEntity);

    MessageEntity toEntity(MessageDto messageDto);
}
