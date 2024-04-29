package social_network.dialogservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social_network.dialogservice.model.DialogEntity;

import java.util.List;

@Repository
public interface DialogRepository extends JpaRepository<DialogEntity, Long> {

    DialogEntity findByAuthorIdAndRecipientId(Long authorId, Long recipientId);

    List<DialogEntity> findAllByAuthorIdOrAllRecipientId(Long authorId, Long recipientId);

    Page<DialogEntity> findAllByAuthorIdOrRecipientIdOrderByLastMessageDesc(Long authorId, Long recipientId, Pageable pageable);

}
