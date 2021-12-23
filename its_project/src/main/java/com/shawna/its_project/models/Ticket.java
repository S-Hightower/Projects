package com.shawna.its_project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    private String priority;
	
	@NotNull
    private String osVersion;
	
	@NotNull
	@Size(min=2, message="Bug summary must be at least 2 letters.")
    private String bugSumm;
	
	@NotNull
	@Size(min=2, message="Bug details must be at least 2 letters.")
    private String bugDetails;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
	
//------------Implement Table Connection-----------
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    	name = "tickets_users",
    	joinColumns = @JoinColumn(name = "ticket_id"),
    	inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    
    
	public Ticket() {
	}

	public Ticket(String priority, String osVersion, String bugSumm, String bugDetails) {
		this.priority = priority;
		this.osVersion = osVersion;
		this.bugSumm = bugSumm;
		this.bugDetails = bugDetails;
	}
	
//-----------Getters/Setters----------------	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getBugSumm() {
		return bugSumm;
	}

	public void setBugSumm(String bugSumm) {
		this.bugSumm = bugSumm;
	}

	public String getBugDetails() {
		return bugDetails;
	}

	public void setBugDetails(String bugDetails) {
		this.bugDetails = bugDetails;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
