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
	
	@Column
	private String name; 
	
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id", insertable=false, updatable=false)
	private Team team_id;
	
	@ManyToMany(mappedBy = "channels")
	private List<User> users = new ArrayList<>();

}
