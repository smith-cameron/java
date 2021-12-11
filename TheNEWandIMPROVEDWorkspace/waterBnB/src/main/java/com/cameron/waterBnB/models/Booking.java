package com.cameron.waterBnB.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bookings")
public class Booking {
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
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date bookingDate;
	
	@NotBlank(message="Quatity of nights required")
	private Integer duration;
	
	private Double bookingCost;
	
//  Table Realationships ----------------------------------
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="guest_id")
    private User guest;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="listing_id")
    private Listing location;
	
//	Bean --------------------------------------------------
	public Booking() {
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
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getStayDuration() {
		return duration;
	}
	public void setStayDuration(Integer duration) {
		this.duration = duration;
	}
	public Double getBookingCost() {
		return bookingCost;
	}
	public void setBookingCost(Double bookingCost) {
		this.bookingCost = bookingCost;
	}
	public User getGuest() {
		return guest;
	}
	public void setGuest(User guest) {
		this.guest = guest;
	}
	public Listing getLocation() {
		return location;
	}
	public void setLocation(Listing location) {
		this.location = location;
	}
	
	
}
