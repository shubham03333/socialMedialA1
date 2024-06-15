package com.connect.socialMedia.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Discussion {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private int imageId;
	private Date date;
	private int likeCount;
	private int viewCount;
	private int hashtagId;
	
	public Discussion(int id, int imageId, Date date, int likeCount, int viewCount, int hashtagId) {	
		this.id = id;
		this.imageId = imageId;
		this.date = date;
		this.likeCount = likeCount;
		this.viewCount = viewCount;
		this.hashtagId = hashtagId;
	}
 
	public Discussion() {
		
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public int getImageId() {
		return imageId;
	}
 
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
 
	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}
 
	public int getLikeCount() {
		return likeCount;
	}
 
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
 
	public int getViewCount() {
		return viewCount;
	}
 
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
 
	public int getHashtagId() {
		return hashtagId;
	}
 
	public void setHashtagId(int hashtagId) {
		this.hashtagId = hashtagId;
	}
 
	@Override
	public String toString() {
		return "Discussions [id=" + id + ", imageId=" + imageId + ", date=" + date + ", likeCount=" + likeCount
				+ ", viewCount=" + viewCount + ", hashtagId=" + hashtagId + "]";
	}
 
}