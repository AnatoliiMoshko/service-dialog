package social_network.dialogservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dto диалога")
public class DialogDto {

    @Schema(description = "Id диалога", example = "1")
    private Long id;

    @Schema(description = "Количество непрочитанных сообщений диалога", example = "10")
    private Long unreadCount;

    @Schema(description = "Собеседник")
    private AccountDto conversationPartner;

    @Schema(description = "Dto сообщения")
    private MessageDto lastMessage;
}
