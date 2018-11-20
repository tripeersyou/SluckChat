package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Channel;
import app.repository.ChannelRepository;

@Component
public class ChannelComponent {
	@Autowired
	ChannelRepository channel_repo;
	
	public Channel getChannel(String name){
		return channel_repo.findByName(name);
	}

}
