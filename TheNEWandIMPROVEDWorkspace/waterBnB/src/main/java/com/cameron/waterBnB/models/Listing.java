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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="listings")
public class Listing {
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
	@NotBlank(message="Address Required")
	@Size(min=15, max=255, message="Must be 15-255 characters")
	private String address;
	
	@NotBlank(message="Description Required")
	@Size(min=2, max=255, message="Must be 2-255 characters")
	private String description;
	
	@NotBlank(message="Cost Required")
	private Double cost;
	
	@NotBlank(message="Size Required")
	private String size;

//	Table Realationships ----------------------------------
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
	
	@OneToMany(mappedBy="listingReviewed",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> recievedReviews;

	@OneToMany(mappedBy="location", fetch = FetchType.LAZY)
    private List<Booking> bookings;
	
	@OneToMany(mappedBy="listing", fetch = FetchType.LAZY)
    private List<Message> messages;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "listing_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersWhoLike;
	
//	Bean --------------------------------------------------
	public Listing() {
	}
	
//	Getter/Setter Pairs ------------------------------------
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public List<Review> getRecievedReviews() {
		return recievedReviews;
	}
	public void setRecievedReviews(List<Review> recievedReviews) {
		this.recievedReviews = recievedReviews;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<User> getUsersWhoLike() {
		return usersWhoLike;
	}
	public void setUsersWhoLike(List<User> usersWhoLike) {
		this.usersWhoLike = usersWhoLike;
	}
	


}
