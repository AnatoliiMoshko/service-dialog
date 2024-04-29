package social_network.dialogservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Dto для количества непрочитанных сообщений диалога")
public class UnreadCountDto {

    @Schema(description = "Количество непрочитанных сообщений в диалоге", example = "10")
    private Long count;
}
