package social_network.dialogservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import social_network.dialogservice.dto.response.GetDialogsRs;
import social_network.dialogservice.dto.response.GetMessagesRs;
import social_network.dialogservice.dto.response.SetStatusMessageReadRs;
import social_network.dialogservice.dto.response.UnreadCountRs;
import social_network.dialogservice.service.DialogService;

@RestController
@RequestMapping("/api/v1/dialogs")
@RequiredArgsConstructor
public class DialogController {

    private final DialogService dialogService;

    @GetMapping
    public ResponseEntity<GetDialogsRs> getAllDialogs(Integer offset, Integer itemPerPage) {
        return ResponseEntity.ok(dialogService.getAllDialogs(offset, itemPerPage));
    }

    @GetMapping("messages")
    public ResponseEntity<GetMessagesRs> getAllMessages(Long companionId, Integer offset, Integer itemPerPage) {
        return ResponseEntity.ok(dialogService.getAllMessages(companionId, offset, itemPerPage));
    }

    @GetMapping("/unreaded")
    public ResponseEntity<UnreadCountRs> getUnreadMessageCount() {
        return ResponseEntity.ok(dialogService.getUnreadMessageCount());
    }

    @PutMapping("/{companionId}")
    public ResponseEntity<SetStatusMessageReadRs> setStatusMessageRead(@PathVariable Long companionId) {
        return ResponseEntity.ok(dialogService.setStatusMessageRead(companionId));
    }
}
