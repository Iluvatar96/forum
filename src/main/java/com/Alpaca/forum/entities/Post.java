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
@Table(name="posts")
public class Post  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7440858569911579680L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private int post_id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="topic")
	private String topic;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private Discussion_Group discussion_Group;
	
	
	
	@Column(name="created_at",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	
	

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
		return "Post [post_id=" + post_id + ", user=" + user + ", topic=" + topic + ", content=" + content
				+ ", discussion_Group=" + discussion_Group + ", created_at=" + created_at + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Discussion_Group getDiscussion_Group() {
		return discussion_Group;
	}

	public void setDiscussion_Group(Discussion_Group discussion_Group) {
		this.discussion_Group = discussion_Group;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getPost_id() {
		return post_id;
	}
	
	public Post() {
	}
}
