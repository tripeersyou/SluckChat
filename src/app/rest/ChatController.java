package app.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.ChannelComponent;
import app.component.ChatComponent;
import app.component.TeamComponent;
import app.component.UserComponent;
import app.entity.Channel;
import app.entity.Chat;
import app.entity.Team;
import app.entity.User;

@Component
@Path("/chats")
public class ChatController {
	
	
	@Autowired
	private ChatComponent chat_comp;
	
	@Autowired
	private UserComponent usercomp;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Chat> getChat(@QueryParam("sender_id")Long sender_id, @QueryParam("recipient_id")Long recipient_id){
		
		User sender = usercomp.getUser(sender_id);
		User recipient = usercomp.getUser(recipient_id);
		return chat_comp.getChat(sender, recipient);
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Chat createChat(@FormParam("recipient") Long recipient_id, @FormParam("sender") Long sender_id, @FormParam("message") String message) throws IOException{
 		try {
 			Chat a = new Chat();
 			
 			User recipient = usercomp.getUser(recipient_id);
 			User sender = usercomp.getUser(sender_id);
 			
 			a.setSender(sender);
 			a.setRecipient(recipient);
 			a.setMessage(message);
 			chat_comp.createChat(a);
 			
 			return a;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
			}
		}
}
