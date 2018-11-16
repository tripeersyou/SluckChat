package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.User;
import app.repository.UserRepository;

@Component
public class UserComponent {
	
	@Autowired
	UserRepository repo;
	
	public User getUser(String lastName){
		return repo.findByLastName(lastName);
	}
}
