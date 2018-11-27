package app.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.UserComponent;
import app.entity.User;

@Component
@Path("/users")
public class UsersController {
	
	@Autowired
	private UserComponent userComponent;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User show(@QueryParam("user_id") Long id) {
		return userComponent.getUser(id);
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser(@FormParam("first_name") String firstName, @FormParam("last_name") String lastName) throws IOException{
		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		return userComponent.create(u);
	}
	
	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User editUser(@FormParam("id") Long id, @FormParam("first_name") String firstName, @FormParam("last_name") String lastName) throws IOException{
		User u = userComponent.getUser(id);
		u.setFirstName(firstName);
		u.setLastName(lastName);
		return userComponent.create(u);
	}
	
}
