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
public class UserBan implements Serializable{
		
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7145289358584522004L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_ban_id")
	private int userBanId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private DiscussionGroup discussionGroup;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;

	@Override
	public String toString() {
		return "User_Ban [user_ban_id=" + userBanId + ", discussion_Group=" + discussionGroup + ", user=" + user
				+ "]";
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
	

	public void setUserBanId(int userBanId) {
		this.userBanId = userBanId;
	}

	public int getUserBanId() {
		return userBanId;
	}
	
	public UserBan() {}
	
}
