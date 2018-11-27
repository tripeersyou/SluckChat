package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import app.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{

	public List<Message> findByChannelId(Long id);
	

}
