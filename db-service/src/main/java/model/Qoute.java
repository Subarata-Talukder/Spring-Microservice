package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qoute", catalog = "db_qoutes" )
public class Qoute {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "qouteName")
	private String qouteName;
	
	public Qoute() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQouteName() {
		return qouteName;
	}

	public void setQouteName(String qouteName) {
		this.qouteName = qouteName;
	}
	
}
