package com.Alpaca.forum.entities;

import java.io.Serializable;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="subscriptions")
public class Subscription implements Serializable {
	
	
	
	private static final long serialVersionUID = 6062181727965813271L;

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subscription_id")
	private int subscriptionId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private DiscussionGroup discussionGroup;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="created_at")
	@Basic
	@Temporal(TemporalType.DATE)
	private Date subscribedAt;

	

	 @PrePersist
	    protected void onCreate() {
	        this.subscribedAt = new Date();
	       
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.subscribedAt = new Date();
	    }

	
	
	@Override
	public String toString() {
		return "Subscription [subscription_id=" + subscriptionId + ", discussion_Group=" + discussionGroup + ", user="
				+ user + ", subscribed_at=" + subscribedAt + "]";
	}

	
	public DiscussionGroup getDiscussionGroup() {
		return discussionGroup;
	}

	public void setDiscussionGroup(DiscussionGroup discussionGroup) {
		this.discussionGroup = discussionGroup;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Date getSubscribedAt() {
		return subscribedAt;
	}

	public void setSubscribedAt(Date subscribedAt) {
		this.subscribedAt = subscribedAt;
	}

	public void setSubscription_id(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}


	public int getSubscriptionId() {
		return subscriptionId;
	}
	
	public Subscription() {
		
	}
}
