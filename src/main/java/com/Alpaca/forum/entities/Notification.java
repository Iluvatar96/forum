package com.Alpaca.forum.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="notifications")
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="notification_id")
	private int notification_id;
	
	
	@Column(name="created_at")
	@Type(type="timestamp")
	private Date created_at;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="sender_id")
	private User sender_User;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="recipient_id")
	private User recipient_User;
	
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="object_id")
	private int object_id;
	
	@Column(name="unread")
	private int unread = 1;

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public User getSender_User() {
		return sender_User;
	}

	public void setSender_User(User sender_User) {
		this.sender_User = sender_User;
	}

	public User getRecipient_User() {
		return recipient_User;
	}

	public void setRecipient_User(User recipient_User) {
		this.recipient_User = recipient_User;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getObject_id() {
		return object_id;
	}

	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}

	public int getUnread() {
		return unread;
	}

	public void setUnread(int unread) {
		this.unread = unread;
	}

	public int getNotification_id() {
		return notification_id;
	}
	
	public Notification() {}
}
