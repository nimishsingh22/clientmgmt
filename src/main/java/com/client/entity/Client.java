package com.client.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "client",uniqueConstraints= @UniqueConstraint(columnNames={"email"}))
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private int id;
    
	@Column(name = "name")
	@NotEmpty
    private String name;
	
    @Column(name = "email")
    @NotEmpty
    private String email;
    
    @Column(name = "password")
    @NotEmpty
    private String password;

    
    @Column(name = "active")
    private Boolean active;
    
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "client_role", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
 public Client() {
	 
 }
    
    
	@Override
public String toString() {
	return "Client [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", active=" + active
			+ ", roles=" + roles + "]";
}


	public Client(int id, @NotEmpty String name, @NotEmpty String email, @NotEmpty String password, Boolean active,
		Set<Role> roles) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.active = active;
	this.roles = roles;
}


	public Client(@NotEmpty String name, @NotEmpty String email, @NotEmpty String password, Boolean active,
		Set<Role> roles) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.active = active;
	this.roles = roles;
}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
    
    
}
