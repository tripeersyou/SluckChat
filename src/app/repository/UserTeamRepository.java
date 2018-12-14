package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Team;
import app.entity.User;
import app.entity.UserTeam;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
	public UserTeam findByUserAndTeam(User u, Team t);
	public List<UserTeam> findByTeam(Team t);
	public List<UserTeam> findByUser(User u);
}
