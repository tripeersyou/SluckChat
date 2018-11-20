package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.User;
import app.repository.UserRepository;

@Component
public class UserComponent {
	
	@Autowired
	UserRepository user_repo;
	
	public User getUser(String last_name){
		return user_repo.findByLastName(last_name);
	}
}
