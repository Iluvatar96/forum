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
@Table(name="user_bans")
public class User_Ban implements Serializable{
		
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7145289358584522004L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_ban_id")
	private int user_ban_id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private Discussion_Group discussion_Group;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;

	@Override
	public String toString() {
		return "User_Ban [user_ban_id=" + user_ban_id + ", discussion_Group=" + discussion_Group + ", user=" + user
				+ "]";
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
	
	

	public void setUser_ban_id(int user_ban_id) {
		this.user_ban_id = user_ban_id;
	}

	public int getUser_ban_id() {
		return user_ban_id;
	}
	
	public User_Ban() {}
	
}
