package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Channel;
import app.entity.Team;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long>{
	public List<Channel> findByTeam(Team team);
}
