package social_network.dialogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DialogMessageDto {

    private Long id;

    private Long authorId;

    private String messageText;

    private Long recipientId;

    private Long time;
}
