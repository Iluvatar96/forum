package com.Alpaca.forum.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private int tag_id;
	
	
	@Column(name="name")
	private String tag_Name;


	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}



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
	
	public Tag() {}
	
}
