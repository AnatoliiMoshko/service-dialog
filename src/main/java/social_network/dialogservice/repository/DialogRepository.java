package social_network.dialogservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social_network.dialogservice.model.Dialog;

import java.util.List;

@Repository
public interface DialogRepository extends JpaRepository<Dialog, Long> {

    Dialog findByAuthorIdAndRecipientId(Long authorId, Long recipientId);

    List<Dialog> findAllByAuthorIdOrAllRecipientId(Long authorId, Long recipientId);

    Page<Dialog> findAllByAuthorIdOrRecipientIdOrderByLastMessageDesc(Long authorId, Long recipientId, Pageable pageable);

}
