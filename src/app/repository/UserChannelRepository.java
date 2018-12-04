package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Channel;
import app.entity.User;
import app.entity.UserChannel;

@Repository
public interface UserChannelRepository extends JpaRepository<UserChannel, Long>{
	public UserChannel findByUserAndChannel(User u, Channel c);

}
