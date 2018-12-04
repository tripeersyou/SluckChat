package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Channel;
import app.entity.User;
import app.entity.UserChannel;
import app.repository.UserChannelRepository;

@Component
public class UserChannelComponent {

	@Autowired
	private UserChannelRepository user_channel_repo;
	
	public UserChannel getUserChannel(User u, Channel c){
		return user_channel_repo.findByUserAndChannel(u, c);
	}
	
	public UserChannel create(UserChannel c){
		user_channel_repo.save(c);
		return c;
	}
	
	public UserChannel goodbye(UserChannel c){
		UserChannel uc = c;
		user_channel_repo.delete(c.getId());
		return uc;
	}
}
