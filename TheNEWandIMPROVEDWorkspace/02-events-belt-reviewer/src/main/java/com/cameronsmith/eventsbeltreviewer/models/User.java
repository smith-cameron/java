package com.cameronsmith.eventsbeltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
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
	@NotBlank(message="Email Required")
	@Email(message="Invalid Email")
	@Pattern(regexp=".[A-Za-z0-9._%+-]+@[A-Za-z0-9.-].+\\..[a-z]{2,6}$", message="Invalid Email")
	private String email;
	@NotBlank(message="First Name Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String firstName;
	@NotBlank(message="Last Name Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String lastName;
	@NotBlank(message="Location Required")
	@Size(min=2, message="Must be more than 2 characters")
	private String location;
	@NotBlank(message="State Required")
	@Size(min=2, message="Must be more than 2 characters")
	private String state;
	@NotBlank(message="Password Required")
	private String password;
	@NotBlank(message="Password Comparison Required")
	@Transient
	private String confirmPassword;
	
	@OneToMany(mappedBy="host",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Event> eventsCreated;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Message> userMessages;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_events", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> eventsAttending;
	
	public User() {
		
	}
	public User(String email, String firstName, String lastName, String location, String state, String password, String confirmPassword) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.state = state;
		this.password = password;
		this.confirmPassword = confirmPassword;
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
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return this.confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public List<Message> getUserMessages() {
		return this.userMessages;
	}
	public void setUserMessages(List<Message> userMessages) {
		this.userMessages = userMessages;
	}
	public List<Event> getEventsCreated() {
		return this.eventsCreated;
	}
	public void setEventsCreated(List<Event> eventsCreated) {
		this.eventsCreated = eventsCreated;
	}
	public List<Event> getEventsAttending() {
		return this.eventsAttending;
	}
	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}
}
