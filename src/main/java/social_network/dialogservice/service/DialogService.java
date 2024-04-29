package social_network.dialogservice.service;

import social_network.dialogservice.dto.response.GetDialogsRs;
import social_network.dialogservice.dto.response.GetMessagesRs;
import social_network.dialogservice.dto.response.SetStatusMessageReadRs;
import social_network.dialogservice.dto.response.UnreadCountRs;

public interface DialogService {
    GetDialogsRs getAllDialogs(Integer offset, Integer itemPerPage);
    GetMessagesRs getAllMessages(Long companionId, Integer offset, Integer itemPerPage);
    UnreadCountRs getUnreadMessageCount();
    SetStatusMessageReadRs setStatusMessageRead(Long companionId);
}
