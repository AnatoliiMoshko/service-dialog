package social_network.dialogservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import social_network.dialogservice.dto.UnreadCountDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Ответ на запрос получения количества непрочитанных сообщений диалога")
public class UnreadCountRs {

    @Schema(description = "Ошибка по запросу", example = "Неверный запрос")
    private String error;

    @Schema(description = "Метка времени", example = "1644234125")
    private Long timestamp;

    private UnreadCountDto data;

    // "error_description" - ???
    @Schema(description = "Описание ошибки", example = "Неверный код авторизации")
    private String errorDescription;
}
