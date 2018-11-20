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
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public UserTeam create(@FormParam("user") Long user_id, @FormParam("team") Long team_id) throws IOException{
		try {
		User user = user_comp.getUser(user_id);
		Team team = team_component.getTeam(team_id);
		UserTeam u = new UserTeam();
		u.setTeam(team);
		u.setUser(user);
		return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
