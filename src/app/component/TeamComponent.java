package app.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Team;
import app.entity.UserTeam;
import app.repository.TeamRepository;
import app.repository.UserTeamRepository;

@Component
public class TeamComponent {
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private UserTeamRepository utRepository;
	
	public Team getTeam(Long id){
		
		System.out.println(id);
		return teamRepository.findOne(id);
	}
	
	public Team create(Team t) {
		teamRepository.save(t);
		return t;
	}
	
	public List<UserTeam> getMembers(Team team){
		return utRepository.findByTeam(team);
	}

}
