package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.UserTeam;
import app.repository.UserTeamRepository;

@Component
public class UserTeamComponent {
	
	@Autowired
	private UserTeamRepository user_team_repo;
	
	public UserTeam getUser(Long id){
		return user_team_repo.findOne(id);
	}
}
