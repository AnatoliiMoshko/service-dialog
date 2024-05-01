package social_network.dialogservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListenerService {

    private final DialogServiceImpl dialogService;

    public void listenMessage(String message) {
        dialogService.saveMessage(message);
    }
}
