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
@Table(name="discussion_groups")
public class Discussion_Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id")
	private int group_id;
	
	
	@Column(name="name")
	private String groupName;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="owner_id")
	private User user;
	
	@Column(name="is_private")
	private int is_private = 0;
	
	
	@Column(name="access_password")
	private String accessPasswd;
	
	@Column(name="created_at")
	@Type(type="timestamp")
	private Date created_at;
	
	@Column(name="group_info")
	private String group_Info;
	
	@Column(name="rules")
	private String rules;
	
	@Column(name = "short_description")
	private String description;

	
	
	
	@Override
	public String toString() {
		return "Discussion_Group [group_id=" + group_id + ", groupName=" + groupName + ", user=" + user
				+ ", is_private=" + is_private + ", accessPasswd=" + accessPasswd + ", created_at=" + created_at
				+ ", group_Info=" + group_Info + ", rules=" + rules + ", description=" + description + "]";
	}

	public Discussion_Group() {
		
	}

	public int getGroup_id() {
		return group_id;
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

	public int getIs_private() {
		return is_private;
	}

	public void setIs_private(int is_private) {
		this.is_private = is_private;
	}

	public String getAccessPasswd() {
		return accessPasswd;
	}

	public void setAccessPasswd(String accessPasswd) {
		this.accessPasswd = accessPasswd;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getGroup_Info() {
		return group_Info;
	}

	public void setGroup_Info(String group_Info) {
		this.group_Info = group_Info;
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
