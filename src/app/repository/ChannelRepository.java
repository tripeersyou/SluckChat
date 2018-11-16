package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Channel;

@Repository
public interface ChannelRepository 
	extends JpaRepository<Channel,Long>{
	
		public Channel findByName(String name);

}
