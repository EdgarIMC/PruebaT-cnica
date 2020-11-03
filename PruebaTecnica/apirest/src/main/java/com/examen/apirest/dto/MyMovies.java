package com.examen.apirest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name = "movie")
public class MyMovies {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="watch_date")
	private String watchDate;
	@Column(name="coments")
	private String comments;
	@Column(name="rating")
	private String rating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWatchDate() {
		return watchDate;
	}
	public void setWatchDate(String watchDate) {
		this.watchDate = watchDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "MyMovies [id=" + id + ", title=" + title + ", watchDate=" + watchDate + ", comments=" + comments
				+ ", rating=" + rating + "]";
	}
	
	
	
	

}
