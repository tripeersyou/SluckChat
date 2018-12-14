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
import app.component.TeamComponent;
import app.component.UserComponent;
import app.component.UserTeamComponent;
import app.entity.Channel;
import app.entity.Team;
import app.entity.User;
import app.entity.UserTeam;

@Component
@Path("/teams")
public class TeamsController {
	
	@Autowired
	private TeamComponent teamComponent;
	
	@Autowired
	private UserComponent user_comp;
	
	@Autowired
	private UserTeamComponent team_comp;
	
	@Autowired 
	private ChannelComponent channel_comp;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Team show(@QueryParam("team_id") Long id) {
		return teamComponent.getTeam(id);
	}
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserTeam> showMembers(@QueryParam("team_id") Long id) {
		Team team = teamComponent.getTeam(id);
		return teamComponent.getMembers(team);
	}
	
	//userteam
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserTeam createUserTeam(@FormParam("user") Long user_id, @FormParam("team") Long team_id) throws IOException{
		User user = user_comp.getUser(user_id);
 		Team team = teamComponent.getTeam(team_id);
		UserTeam u = new UserTeam();
		u.setTeam(team);
		u.setUser(user);
		return team_comp.create(u);
	}
	
	@POST
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserTeam goodbyeUser(@FormParam("team") Long team_id, @FormParam("user") Long user_id) throws IOException{
		User u = user_comp.getUser(user_id);
		Team t = teamComponent.getTeam(team_id);
		UserTeam ut = team_comp.getUserTeam(u,t);
		return team_comp.goodbye(ut);
	}
	 
	//team
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Team create(@FormParam("name") String name) throws IOException{
		Team t = new Team();
		t.setName(name);
		return teamComponent.create(t);
	}
	
	@POST 
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Team edit(@FormParam("id") Long id, @FormParam("name") String name) throws IOException{
		Team t = teamComponent.getTeam(id);
		t.setName(name);
		return teamComponent.create(t);
	}
	
	//channel
	@GET
	@Path("/channel/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Channel> teamChannels(@QueryParam("team_id") long team_id) throws IOException{
			Team team = teamComponent.getTeam(team_id);
			return channel_comp.getChannels(team);
	}
	
	@POST
	@Path("/channel/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Channel createChannel(@FormParam("name") String name, @FormParam("team") long team_id) throws IOException{
			Team team = teamComponent.getTeam(team_id);
			Channel c = new Channel();
			c.setTeam(team);
			c.setName(name);
			return channel_comp.createChannel(c);
	}
	
	@POST 
	@Path("/channel/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Channel editChannel(@FormParam("name") String name, @FormParam("id")Long id) throws IOException{
		Channel c = channel_comp.getChannel(id);
		c.setName(name);
		return channel_comp.createChannel(c);
	}
	
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserTeam> userTeams(@QueryParam("user_id") Long id){
		User u = user_comp.getUser(id);
		return team_comp.getTeamUser(u);
	}
}
