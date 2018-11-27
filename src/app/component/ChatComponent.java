package app.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Channel;
import app.entity.Chat;
import app.entity.User;
import app.repository.ChannelRepository;
import app.repository.ChatRepository;

@Component
public class ChatComponent {
	
	@Autowired
	private ChatRepository chatRepository;
	
	public List<Chat> getChat(User sender_id, User recipient_id){
		return chatRepository.findBySenderAndRecipient(sender_id, recipient_id);
	}

	public Chat createChat(Chat c){
		chatRepository.save(c);
		return c;
	}

	
}
