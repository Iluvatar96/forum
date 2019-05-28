package com.Alpaca.forum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="comments")
public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -986484681148331019L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="content")
	private String content;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="post_id")
	private Post post;
	
	@Column(name="created_at",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	
	
	public int getCommentId() {
		return commentId;
	}

	
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	
	
	 public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	@PrePersist
	    protected void onCreate() {
	        this.createdAt = new Date();
	       
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.createdAt = new Date();
	    }

	@Override
	public String toString() {
		return "Comment [comment_id=" + commentId + ", user=" + user + ", content=" + content + ", post=" + post
				+ ", created_at=" + createdAt + "]";
	}
	
	public Comment() {}
}
