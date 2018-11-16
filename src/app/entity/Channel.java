package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Channel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Team team_id) {
		this.team_id = team_id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Column
	private String name; 
	
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id", insertable=false, updatable=false)
	private Team team_id;
	
	@ManyToMany(mappedBy = "channels")
	private List<User> users = new ArrayList<>();

}
