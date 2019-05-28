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
@Table(name="group_tags")
public class GroupTag implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2227360464743264876L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_tag_id")
	private int groupTagId;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private DiscussionGroup discussionGroup;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="tag_id")
	private Tag tag;
	
	

	public int getGroupTagId() {
		return groupTagId;
	}

	

	public void setGroupTagId(int groupTagId) {
		this.groupTagId = groupTagId;
	}



	public DiscussionGroup getDiscussionGroup() {
		return discussionGroup;
	}

	public void setDiscussionGroup(DiscussionGroup discussionGroup) {
		this.discussionGroup = discussionGroup;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}



	@Override
	public String toString() {
		return "Group_Tag [group_tag_id=" + groupTagId + ", discussionGroup=" + discussionGroup + ", tag=" + tag
				+ "]";
	}
	
	public GroupTag() {}
	
}
