package app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	 @OneToMany(
			 	mappedBy = "user",
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	 private List<UserTeam> teams;
	 
//	public List<Team> getTeams() {
//		return teams;
//	}
//
//
//	public void setTeams(List<Team> teams) {
//		this.teams = teams;
//	}

//
//	public List<Channel> getChannels() {
//		return channels;
//	}
//
//
//	public void setChannels(List<Channel> channels) {
//		this.channels = channels;
//	}
	
	
}
