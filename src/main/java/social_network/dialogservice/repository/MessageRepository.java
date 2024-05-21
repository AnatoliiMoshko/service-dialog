package social_network.dialogservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social_network.dialogservice.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findMessageEntitiesByDialogIdOrderByTimeDesc(Long dialogId, Pageable pageable);

}
