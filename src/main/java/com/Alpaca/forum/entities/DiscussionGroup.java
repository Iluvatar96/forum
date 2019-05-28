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
@Table(name="discussion_groups")
public class DiscussionGroup implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8921296928935310305L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id")
	private int groupId;
	
	
	@Column(name="name")
	private String groupName;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="owner_id")
	private User user;
	
	@Column(name="is_private")
	private int isPrivate = 0;
	
	
	@Column(name="access_password")
	private String accessPasswd;
	
	@Column(name="created_at",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="group_info")
	private String groupInfo;
	
	@Column(name="rules")
	private String rules;
	
	@Column(name = "short_description")
	private String description;

	

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
		return "Discussion_Group [group_id=" + groupId + ", groupName=" + groupName + ", user=" + user
				+ ", is_private=" + isPrivate + ", accessPasswd=" + accessPasswd + ", created_at=" + createdAt
				+ ", group_Info=" + groupInfo + ", rules=" + rules + ", description=" + description + "]";
	}

	public DiscussionGroup() {
		
	}
	
	

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getGroupId() {
		return groupId;
	}


	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIsPrivate() {
		return isPrivate;
	}

	public void setIs_private(int isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getAccessPasswd() {
		return accessPasswd;
	}

	public void setAccessPasswd(String accessPasswd) {
		this.accessPasswd = accessPasswd;
	}

	

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getGroup_Info() {
		return groupInfo;
	}

	public void setGroup_Info(String group_Info) {
		this.groupInfo = group_Info;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
