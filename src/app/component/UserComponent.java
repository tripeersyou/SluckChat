package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.User;
import app.repository.UserRepository;

@Component
public class UserComponent {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(Long id){
		return userRepository.findOne(id);
	}
	
	public User create(User u) {
		userRepository.save(u);
		return u;
	}
	
	
}
