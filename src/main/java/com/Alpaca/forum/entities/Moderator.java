package com.Alpaca.forum.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="moderators")
public class Moderator implements Serializable {
	
	
	
	private static final long serialVersionUID = -801018139774885099L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="moderatr_id")
	private int moderatorId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private DiscussionGroup discussionGroup;

	
	
	public Moderator(int moderator_id, User user, DiscussionGroup discussion_Group) {
	
		this.moderatorId = moderator_id;
		this.user = user;
		this.discussionGroup = discussion_Group;
	}

	@Override
	public String toString() {
		return "Moderator [moderator_id=" + moderatorId + ", user=" + user + ", discussion_Group=" + discussionGroup
				+ "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DiscussionGroup getDiscussionGroup() {
		return discussionGroup;
	}

	public void setDiscussion_Group(DiscussionGroup discussionGroup) {
		this.discussionGroup = discussionGroup;
	}
	
	

	public void setModerator_id(int moderatorId) {
		this.moderatorId = moderatorId;
	}

	public int getModeratorId() {
		return moderatorId;
	}
	public Moderator(){}
	}
