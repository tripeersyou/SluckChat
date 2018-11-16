package app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.User;

@Repository
public interface UserRepository 
	extends JpaRepository<User, Long>{
	
		public User findByLastName(String lastName);
	}
