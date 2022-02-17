package com.cameronsmith.exam.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ideas")
public class Idea {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	@NotBlank(message="Idea Required")
	private String ideaContent;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User ideaCreator;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "idea_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likers;
	
	public Idea() {
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getIdeaContent() {
		return this.ideaContent;
	}
	public void setIdeaContent(String ideaContent) {
		this.ideaContent = ideaContent;
	}
	public User getIdeaCreator() {
		return this.ideaCreator;
	}
	public void setIdeaCreator(User ideaCreator) {
		this.ideaCreator = ideaCreator;
	}
	public List<User> getUsersWhoLike() {
		return this.likers;
	}
	public void setUsersWhoLike(List<User> usersWhoLike) {
		this.likers = usersWhoLike;
	}
	
//	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
//	private Date updatedAt;
//	@PrePersist
//	protected void onCreate(){
//		this.createdAt = new Date();
//	}
//	@PreUpdate
//	protected void onUpdate(){
//		this.updatedAt = new Date();
//	}
//	@NotBlank(message="Idea Required")
//	private String ideaContent;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private User ideaCreator;
//	
//	@ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "likes", 
//        joinColumns = @JoinColumn(name = "idea_id"), 
//        inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> likers;
//	
//	public Idea() {
//	}
//	public Long getId() {
//		return this.id;
//	}
}
