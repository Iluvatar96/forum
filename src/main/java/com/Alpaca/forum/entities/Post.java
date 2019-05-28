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
	

	private static final long serialVersionUID = -7440858569911579680L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postId;
	
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
	private DiscussionGroup discussionGroup;
	
	
	
	@Column(name="created_at",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	
	

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
		return "Post [post_id=" + postId + ", user=" + user + ", topic=" + topic + ", content=" + content
				+ ", discussion_Group=" + discussionGroup + ", created_at=" + createdAt + "]";
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

	public DiscussionGroup getDiscussionGroup() {
		return discussionGroup;
	}

	public void setDiscussionGroup(DiscussionGroup discussionGroup) {
		this.discussionGroup = discussionGroup;
	}

	
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setPost_id(int postId) {
		this.postId = postId;
	}

	public int getPostId() {
		return postId;
	}
	
	public Post() {
	}
}
