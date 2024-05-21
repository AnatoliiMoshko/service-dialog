package social_network.dialogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DialogMessage {

    private Long accountId;

    private DialogMessageDto data;
}
