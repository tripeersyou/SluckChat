package app.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.User;
import app.repository.UserRepository;

@Component
public class DataSeeder {
	@Autowired
	private UserRepository user_repo;
	
	@PostConstruct
	public void init(){
		if (user_repo.count()== 0) {
			User u = createUser("Luis Gabriel", "Cajucom");
			user_repo.save(u);		
			}
	}
	
	private User createUser(String firstName, String lastName) {
		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		return u;
	}
}

