package app.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Channel;
import app.entity.Team;
import app.entity.User;
import app.repository.UserRepository;

@Component
public class UserComponent {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User getUser(Long id){
		return userRepository.findOne(id);
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User create(User u) {
		userRepository.save(u);
		return u;
	}
	
	public Long authenticate(String username, String password) {
		List<User> u = userRepository.findByUsernameAndPassword(username, password);
		if (u.size() > 0 ) {
			return u.get(0).getId();
		} else { 
			return Integer.toUnsignedLong(0);
		}
		
	}

}
