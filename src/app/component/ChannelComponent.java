package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Channel;
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

	public void delete(Channel channel) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
