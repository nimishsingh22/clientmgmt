package com.client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int id;
	
	@Column(name = "role")
	@NotEmpty
	private String role;

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}

	public Role(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role() {
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
