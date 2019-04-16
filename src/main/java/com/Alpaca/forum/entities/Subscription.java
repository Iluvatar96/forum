package com.Alpaca.forum.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="subscriptions")
public class Subscription {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subscription_id")
	private int subscription_id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private Discussion_Group discussion_Group;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="created_at")
	@Basic
	@Temporal(TemporalType.DATE)
	private Date subscribed_at;

	@Override
	public String toString() {
		return "Subscription [subscription_id=" + subscription_id + ", discussion_Group=" + discussion_Group + ", user="
				+ user + ", subscribed_at=" + subscribed_at + "]";
	}

	public Discussion_Group getDiscussion_Group() {
		return discussion_Group;
	}

	public void setDiscussion_Group(Discussion_Group discussion_Group) {
		this.discussion_Group = discussion_Group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getSubscribed_at() {
		return subscribed_at;
	}

	public void setSubscribed_at(Date subscribed_at) {
		this.subscribed_at = subscribed_at;
	}

	public int getSubscription_id() {
		return subscription_id;
	}
	
	public Subscription() {
		
	}
}
