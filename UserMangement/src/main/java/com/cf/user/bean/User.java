package com.cf.user.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "management_user", schema = "management")
public class User implements Serializable {

	private static final long serialVersionUID = 1461242163120594811L;

	@Id
	@GeneratedValue(generator = "idSequence")
	@SequenceGenerator(schema = "management", name = "idSequence", sequenceName = "user_seq", allocationSize = 1)
	@Column(name = "ID")
	private long id;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "STATUS")
	private String status;

	public User() {

	}

	public User(long id, String email, String password, String status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
