package social_network.dialogservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private ZonedDateTime time;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "message_text", nullable = false)
    private String messageText;

    @Column(name = "read_status", nullable = false)
    private String readStatus;

    @ManyToOne
    @JoinColumn(name = "dialog_id", referencedColumnName = "id")
    private Dialog dialogId;
}
