package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Team;
import app.entity.User;
import app.entity.UserTeam;
import app.repository.UserTeamRepository;

@Component
public class UserTeamComponent {
	
	@Autowired
	private UserTeamRepository user_team_repo;
	
	public UserTeam getUserTeam(User u, Team t){
			return user_team_repo.findByUserAndTeam(u, t);
	}
	
	public UserTeam create(UserTeam u){
		user_team_repo.save(u);
		return u;
	}
	
	public UserTeam goodbye(UserTeam u){
		UserTeam ut = u;
		user_team_repo.delete(u.getId());;
		return ut;
	}
}

