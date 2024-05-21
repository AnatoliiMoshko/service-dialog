package social_network.dialogservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerService {

    private final DialogServiceImpl dialogService;

    public void listenMessage(JsonNode message) {
        dialogService.saveMessage(message);
    }
}
