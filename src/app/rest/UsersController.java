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
import org.springframework.stereotype.Controller;

import app.component.UserComponent;
import app.entity.User;
import app.repository.UserRepository;

@Component
@Path("/users")
public class UsersController {
	
	@Autowired
	UserComponent user_comp;
	
	@Autowired
	UserRepository user_repo; 
	
	@GET 
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUsers(@QueryParam("name") String last_name) throws IOException{
		return user_comp.getUser(last_name);
	}
	
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String addUser(@FormParam("a") String firstName, @FormParam("b") String lastName){
		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		user_repo.save(u);
		return "welcome " + firstName +" "+ lastName + " to the party";
	}
}
