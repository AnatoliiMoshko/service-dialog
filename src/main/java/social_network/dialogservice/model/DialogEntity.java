package social_network.dialogservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "dialogs")
public class DialogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "recipient_id", nullable = false)
    private Long recipientId;

    @Column(name = "unread_count_author")
    private Long unreadCountAuthor;

    @Column(name = "unread_count_author")
    private Long unreadCountRecipient;

    @Column(name = "last_message")
    private Long lastMessage;

    @OneToMany(mappedBy = "dialog", cascade = CascadeType.ALL)
    private List<MessageEntity> messages;
}
