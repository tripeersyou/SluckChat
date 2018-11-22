package app.rest;

import java.io.IOException;

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
import app.component.TeamComponent;
import app.entity.Channel;
import app.entity.Team;

@Component
@Path("channels")
public class ChannelController {
	
	@Autowired
	private ChannelComponent channel_comp;
	
	@Autowired
	private TeamComponent team_comp;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Channel get(@QueryParam("id")Long id){
		return channel_comp.getChannel(id);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Channel createChannel(@FormParam("name") String name, @FormParam("team") long team_id) throws IOException{
 		try {
 			System.out.println(team_id);
 			
 			
			Team team = team_comp.getTeam(team_id);
			Channel c = new Channel();
			c.setTeam(team);
			c.setName(name);
			return channel_comp.createChannel(c);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
			}
		}
}
