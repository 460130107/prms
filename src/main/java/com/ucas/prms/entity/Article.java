package com.ucas.prms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:article entity
 * @author:Chen Peng
 * @time:2017年5月7日 下午10:13:33
 */
@Entity
@Table(name = "articles")
public class Article {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="title")
	private String title;

	@Column(name="content")
	private String content;

//	@Column(name="author")
//	private User author;

	@Column(name="post_time")
	private Date postTime;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	public User getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(User author) {
//		this.author = author;
//	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	
}
