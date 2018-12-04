package app.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.ChannelComponent;
import app.component.UserChannelComponent;
import app.component.UserComponent;
import app.entity.Channel;
import app.entity.User;
import app.entity.UserChannel;

@Component
@Path("channels")
public class ChannelController {
	
	@Autowired
	private ChannelComponent channel_comp;
	
	@Autowired 
	private UserComponent user_comp;
	
	@Autowired
	private UserChannelComponent user_channel_comp;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserChannel createChannel(@FormParam("user") Long user_id, @FormParam("channel") Long channel_id) throws IOException{
			User user = user_comp.getUser(user_id);
			Channel channel = channel_comp.getChannel(channel_id);
			UserChannel uc = new UserChannel();
			uc.setChannel(channel);
			uc.setUser(user);
			return user_channel_comp.create(uc);
		} 
	
	@POST
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserChannel goodbyeUser(@FormParam("user") Long user_id, @FormParam("channel") Long channel_id) throws IOException{
		User u = user_comp.getUser(user_id);
		Channel c = channel_comp.getChannel(channel_id);
		UserChannel ut = user_channel_comp.getUserChannel(u, c);
		return user_channel_comp.goodbye(ut);
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Channel goodbyeChannel(@FormParam("channel") Long channel_id) throws IOException{
		Channel c = channel_comp.getChannel(channel_id);
		return channel_comp.goodbyeChannel(c);
	}
	
	
}
