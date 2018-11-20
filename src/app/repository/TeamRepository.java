package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}