package com.cameron.waterBnB.models;

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
	@NotBlank(message="Password Required")
	@Size(min=8, message="Must Be Over 8 Characters")
	private String password;
	@NotBlank(message="Password Comparison Required")
	@Size(min=8, message="Must Be Over 8 Characters")
	@Transient
	private String confirmPassword;
	
//	Table Realationships ----------------------------------
	@OneToMany(mappedBy="host",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Listing> hostedListings;
	
	@OneToMany(mappedBy="sender", fetch = FetchType.LAZY)
    private List<Message> sentMessages;
	
	@OneToMany(mappedBy="recipient",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> recievedMessages;
	
	@OneToMany(mappedBy="reviewer", fetch = FetchType.LAZY)
    private List<Review> listingsReviewed;
	
	@OneToMany(mappedBy="guest", fetch = FetchType.LAZY)
    private List<Booking> listingsBooked;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "listing_id")
    )
    private List<Listing> listingsLiked;
	
//	Bean --------------------------------------------------
	public User() {
	}
	
	public User(String email, String firstName, String lastName, String password, String confirmPassword) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	//	Getter/Setter Pairs -----------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public List<Listing> getHostedListings() {
		return hostedListings;
	}
	public void setHostedListings(List<Listing> hostedListings) {
		this.hostedListings = hostedListings;
	}
	public List<Message> getSentMessages() {
		return sentMessages;
	}
	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}
	public List<Message> getRecievedMessages() {
		return recievedMessages;
	}
	public void setRecievedMessages(List<Message> recievedMessages) {
		this.recievedMessages = recievedMessages;
	}
	public List<Review> getListingsReviewed() {
		return listingsReviewed;
	}
	public void setListingsReviewed(List<Review> listingsReviewed) {
		this.listingsReviewed = listingsReviewed;
	}
	public List<Booking> getListingsBooked() {
		return listingsBooked;
	}
	public void setListingsBooked(List<Booking> listingsBooked) {
		this.listingsBooked = listingsBooked;
	}
	public List<Listing> getListingsLiked() {
		return listingsLiked;
	}
	public void setListingsLiked(List<Listing> listingsLiked) {
		this.listingsLiked = listingsLiked;
	}
	
}

