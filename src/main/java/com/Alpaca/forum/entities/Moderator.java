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
	/**
	 * 
	 */
	private static final long serialVersionUID = -801018139774885099L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="moderatr_id")
	private int moderator_id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private Discussion_Group discussion_Group;

	
	
	public Moderator(int moderator_id, User user, Discussion_Group discussion_Group) {
	
		this.moderator_id = moderator_id;
		this.user = user;
		this.discussion_Group = discussion_Group;
	}

	@Override
	public String toString() {
		return "Moderator [moderator_id=" + moderator_id + ", user=" + user + ", discussion_Group=" + discussion_Group
				+ "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Discussion_Group getDiscussion_Group() {
		return discussion_Group;
	}

	public void setDiscussion_Group(Discussion_Group discussion_Group) {
		this.discussion_Group = discussion_Group;
	}
	
	

	public void setModerator_id(int moderator_id) {
		this.moderator_id = moderator_id;
	}

	public int getModerator_id() {
		return moderator_id;
	}
	public Moderator(){}
	}
