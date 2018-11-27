package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Channel;
import app.entity.User;
import app.entity.Chat;


@Repository
public interface ChatRepository extends JpaRepository<Chat,Long>{
	public List<Chat> findBySenderAndRecipient(User sender_id, User recipient_id);
}
