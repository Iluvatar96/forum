package com.Alpaca.forum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="notifications")
public class Notification implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8229053995172351175L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="notification_id")
	private int notificationId;
	
	
	@Column(name="created_at")
	@Type(type="timestamp")
	private Date createdAt;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="sender_id")
	private User senderUser;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="recipient_id")
	private User recipientUser;
	
	
	
	
	@Enumerated(EnumType.STRING)
	private com.Alpaca.forum.entities.Type type;
	
	
	@Column(name="object_id")
	private int objectId;
	
	@Column(name="unread")
	private int unread = 1;


	 @PrePersist
	    protected void onCreate() {
	        this.createdAt = new Date();
	       
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        this.createdAt = new Date();
	    }

	
	

	public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

	public User getSenderUser() {
		return senderUser;
	}

	public void setSenderUser(User senderUser) {
		this.senderUser = senderUser;
	}

	public User getRecipientUser() {
		return recipientUser;
	}

	public void setRecipientUser(User recipientUser) {
		this.recipientUser = recipientUser;
	}


	
	

	public com.Alpaca.forum.entities.Type getType() {
		return type;
	}

	public void setType(com.Alpaca.forum.entities.Type type) {
		this.type = type;
	}

	public void setNotification_id(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public int getUnread() {
		return unread;
	}

	public void setUnread(int unread) {
		this.unread = unread;
	}

	public int getNotificationId() {
		return notificationId;
	}
	
	public Notification() {}
}
