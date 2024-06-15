package com.connect.socialMedia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String comment;
 
	public Comment(int id, String comment) {
		this.id = id;
		this.comment = comment;
	}
 
	public Comment() {
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getComment() {
		return comment;
	}
 
	public void setComment(String comment) {
		this.comment = comment;
	}
 
	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + "]";
	}
}