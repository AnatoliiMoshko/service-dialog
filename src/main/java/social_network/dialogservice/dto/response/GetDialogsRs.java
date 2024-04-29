package social_network.dialogservice.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import social_network.dialogservice.dto.DialogDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Ответ на запрос получения списка диалогов пользователя")
public class GetDialogsRs {

    @Schema(description = "Ошибка по запросу", example = "Неверный запрос")
    private String error;

    @Schema(description = "Описание ошибки", example = "Неверный код авторизации")
    private String errorDescription;

    @Schema(description = "Метка времени", example = "1644234125")
    private Long timestamp;

    @Schema(description = "Количество диалогов пользователя в списке", example = "10")
    private Integer total;

    @Schema(description = "Отступ от начала списка", example = "0")
    private Integer offset;

    @Schema(description = "Количество диалогов пользователя на страницу", example = "20")
    private Integer perPage;

    @Schema(description = "Id текущего пользователя", example = "55")
    private Long currentUserId;

    @Schema(description = "Список диалогов пользователя")
    private List<DialogDto> data;
}
