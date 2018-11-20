package app.component;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.entity.Channel;
import app.entity.Team;
import app.entity.User;
import app.repository.ChannelRepository;
import app.repository.TeamRepository;
import app.repository.UserRepository;

@Component
public class DataSeeder {
	@Autowired
	private UserRepository user_repo;
	
	@Autowired 
	private TeamRepository team_repo;
	
	@Autowired
	private ChannelRepository channel_repo;
	
	//users
	@PostConstruct
	public void init(){
		if (user_repo.count()== 0) {
			User u = createUser("Luis Gabriel", "Cajucom");
			user_repo.save(u);	
			
			User u2 = createUser("John Vincent", "Agbayani");
			user_repo.save(u2);
			
			User u3 = createUser("John Paulo","Gozum");
			user_repo.save(u3);
					
			}
		
	}
	
	private User createUser(String firstName, String lastName) {
		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		return u;
	}
	
	//team
	@PostConstruct
	public void init2(){
		if (team_repo.count()== 0) {
			Team t = createTeam("MISA");
			team_repo.save(t);	
		}
	}
	
	private Team createTeam(String name) {
		Team t = new Team();
		t.setName(name);
		return t;
	}
			
	//channel
	private Channel createChannel(String name){
		Channel c = new Channel();
		c.setName(name);
		return c;
	}		
}

