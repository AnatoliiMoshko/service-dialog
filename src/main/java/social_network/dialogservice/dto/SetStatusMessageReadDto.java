package social_network.dialogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dto ответа на запрос пометить сообщение как прочитанное")
public class SetStatusMessageReadDto {

    @Schema(description = "Сообщение о выполнении", example = "ok")
    private String message;
}
