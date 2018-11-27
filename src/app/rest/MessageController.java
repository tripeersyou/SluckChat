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
import app.component.MessageComponent;
import app.component.UserComponent;
import app.entity.Channel;
import app.entity.Chat;
import app.entity.Message;
import app.entity.User;

@Component
@Path("/messages")
public class MessageController {
	
	@Autowired
	private MessageComponent message_comp;
	
	@Autowired
	private ChannelComponent channel_comp;
	
	@Autowired
	private UserComponent user_comp;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> get(@QueryParam("channel_id")Long channel_id){
		
		return message_comp.getMessages(channel_id);
		
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Message createMessage(@FormParam("message") String text, @FormParam("user_id")
	long user_id, @FormParam("channel_id") long channel_id) throws IOException{
		
 		try {
 			Message message = new Message();
 			message.setMessage(text);
 			
 			Channel targetChannel = channel_comp.getChannel(channel_id);
 			message.setChannel(targetChannel);
 			
 			User targetUser = user_comp.getUser(user_id);
 			message.setUser_id(targetUser);
 			
 			message_comp.createMessage(message);
 			return message;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
			}
		}
}
