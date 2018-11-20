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

import app.component.TeamComponent;
import app.entity.Team;

@Component
@Path("/teams")
public class TeamsController {
	
	@Autowired
	private TeamComponent teamComponent;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Team show(@QueryParam("team_id") Long id) {
		return teamComponent.getTeam(id);
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Team create(@FormParam("name") String name) throws IOException{
		Team t = new Team();
		t.setName(name);
		return teamComponent.create(t);
	}
}
