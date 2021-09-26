package com.codingdojo.mvc1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Book {
//	Attributes -----------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 200)
    private String title;
    @Size(min = 5, max = 200)
    private String description;
    @Size(min = 3, max = 40)
    private String language;
    @Size(min = 100)
    private int pages;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
