package com.Alpaca.forum.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tags")
public class Tag implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5276789291444411152L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tag_id")
	private int tagId;
	
	
	
	@NotNull
	@Column(name="name")
	private String tagName;


	public void setTag_id(int tagId) {
		this.tagId = tagId;
	}



	public Tag(int tagId, @NotNull String tagName) {
		
		this.tagId = tagId;
		this.tagName = tagName;
	}



	public int getTagId() {
		return tagId;
	}



	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}



	@Override
	public String toString() {
		return "Tag [tag_id=" + tagId + ", tag_Name=" + tagName + "]";
	}
	
	public Tag() {}
	
}
