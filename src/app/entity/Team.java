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
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
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
	
	@OneToMany(
				mappedBy="team",
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	 private List<UserTeam> users;
	
	@OneToMany(
			mappedBy="team",
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Channel> channels;	
}
