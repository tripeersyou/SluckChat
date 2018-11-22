package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.UserTeam;
import app.repository.UserTeamRepository;

@Component
public class UserTeamComponent {
	
	@Autowired
	private UserTeamRepository user_team_repo;
	
	public UserTeam getUserTeam(Long id){
		try {
			return user_team_repo.findOne(id);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public UserTeam create(UserTeam u){
		user_team_repo.save(u);
		return u;
	}
}

