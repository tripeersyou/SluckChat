package app.rest;

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
import app.entity.User;
import app.repository.TeamRepository;

@Component
@Path("/teams")
public class TeamsController {
	
	@Autowired
	TeamComponent team_comp;
	
	@Autowired
	TeamRepository team_repo;
	
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Team getTeam(@QueryParam("name") String name){
		return team_comp.getTeam(name);
	}
	
	@POST
	@Path("/addteam")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String addTeam(@FormParam("a") String name){
		Team t = new Team();
		t.setName(name);
		return "welcome " + name + " to the party";
	}
}
