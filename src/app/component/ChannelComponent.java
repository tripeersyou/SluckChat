package app.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Channel;
import app.entity.Team;
import app.repository.ChannelRepository;

@Component
public class ChannelComponent {
	
	@Autowired
	private ChannelRepository channelRepository;
	
	public Channel getChannel(Long id){
		return channelRepository.findOne(id);
	}

	public Channel createChannel(Channel c){
		channelRepository.save(c);
		return c;
	}

	public Channel goodbyeChannel(Channel c){
		Channel cc = c;
		channelRepository.delete(c.getId());
		return cc;
	}
	
	public List<Channel> getChannels(Team team){
		return channelRepository.findByTeam(team);
	}
	
}
