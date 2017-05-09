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
 * @Description:评论实体
 * @author:Chen Peng
 * @time:2017年5月9日 下午7:18:25
 */
@Entity
@Table(name="replies")
public class Reply {
	
	@Id
	@Column(name = "reply_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	@Column(name="content", columnDefinition="TEXT")
	private String content;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="author_id")
	private User author;

	@Column(name="post_time")
	private Date postTime;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="article_id")
	private Article article;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
