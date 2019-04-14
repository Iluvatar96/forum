package com.Alpaca.forum.entities;

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
public class Group_Tag {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_tag_id")
	private int group_tag_id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="group_id")
	private Discussion_Group discussion_Group;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="tag_id")
	private Tag tag;

	public int getGroup_tag_id() {
		return group_tag_id;
	}

	

	public Discussion_Group getDiscussion_Group() {
		return discussion_Group;
	}

	public void setDiscussion_Group(Discussion_Group discussion_Group) {
		this.discussion_Group = discussion_Group;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}



	@Override
	public String toString() {
		return "Group_Tag [group_tag_id=" + group_tag_id + ", discussion_Group=" + discussion_Group + ", tag=" + tag
				+ "]";
	}
	
	
	
}
