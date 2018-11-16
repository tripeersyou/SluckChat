package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Team;
import app.repository.TeamRepository;

@Component
public class TeamComponent {
	@Autowired
	TeamRepository team_repo;
	
	public Team getTeam(String name){
		return team_repo.findByName(name);
	}

}
