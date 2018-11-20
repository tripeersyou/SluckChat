package app.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user_id;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private Channel channel_id;
	
	//not sure if tama 
	@Basic(optional = false)
	@Column(insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Channel getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Channel channel_id) {
		this.channel_id = channel_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
