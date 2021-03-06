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

import app.component.TeamComponent;
import app.component.UserComponent;
import app.component.UserTeamComponent;
import app.entity.Team;
import app.entity.User;
import app.entity.UserTeam;

@Component
@Path("userteams")
public class UserTeamController {
	
	@Autowired
	private UserTeamComponent team_comp;
	
	@Autowired
	private UserComponent user_comp;
	
	@Autowired
	private TeamComponent team_component;

	
	@POST
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserTeam goodbyeUser(@FormParam("team") Long team_id, @FormParam("user") Long user_id) throws IOException{
		User u = user_comp.getUser(user_id);
		Team t = team_component.getTeam(team_id);
		UserTeam ut = team_comp.getUserTeam(u,t);
		return team_comp.goodbye(ut);
	}
	
}
 	