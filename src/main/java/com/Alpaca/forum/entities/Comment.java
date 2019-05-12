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
	private int comment_id;
	
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
	private Date created_at;

	public int getComment_id() {
		return comment_id;
	}

	
	
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	 @PrePersist
	    protected void onCreate() {
	        this.created_at = new Date();
	       
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.created_at = new Date();
	    }

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", user=" + user + ", content=" + content + ", post=" + post
				+ ", created_at=" + created_at + "]";
	}
	
	public Comment() {}
}
