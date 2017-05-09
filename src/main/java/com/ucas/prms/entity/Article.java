package com.ucas.prms.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Description:文章实体
 * @author:Chen Peng
 * @time:2017年5月9日 下午7:18:04
 */
@Entity
@Table(name = "articles")
public class Article {

	@Id
	@Column(name = "article_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="title")
	private String title;

	@Lob
	@Column(name="content", columnDefinition="TEXT")
	private String content;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="author_id")
	private User author;

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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	
}
