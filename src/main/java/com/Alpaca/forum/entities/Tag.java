package com.Alpaca.forum.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class Tag {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tag_id")
	private int tag_id;
	
	
	@Column(name="name")
	private String tag_Name;


	public int getTag_id() {
		return tag_id;
	}



	public String getTag_Name() {
		return tag_Name;
	}


	public void setTag_Name(String tag_Name) {
		this.tag_Name = tag_Name;
	}



	@Override
	public String toString() {
		return "Tag [tag_id=" + tag_id + ", tag_Name=" + tag_Name + "]";
	}
	
	
}
