package app.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Channel;
import app.entity.Message;
import app.repository.MessageRepository;

@Component
public class MessageComponent {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public List<Message> getMessages(Long id){
		return messageRepository.findByChannelId(id);
	}

	public Message createMessage(Message c){
		messageRepository.save(c);
		return c;
	}

	
}
