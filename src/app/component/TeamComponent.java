package app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Team;
import app.repository.TeamRepository;

@Component
public class TeamComponent {
	@Autowired
	private TeamRepository teamRepository;
	
	public Team getTeam(Long id){
		
		System.out.println(id);
		return teamRepository.findOne(id);
	}
	
	public Team create(Team t) {
		teamRepository.save(t);
		return t;
	}

}
