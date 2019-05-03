package com.Alpaca.forum.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.Alpaca.forum.dao.Discussion_GroupDAO;
import com.Alpaca.forum.entities.Discussion_Group;
import com.Alpaca.forum.entities.Moderator;
import com.Alpaca.forum.entities.Tag;
import com.Alpaca.forum.entities.User;

public class Discussion_GroupDAOImpl implements Discussion_GroupDAO {

	
	private EntityManager entityManager;
	
	
	@Autowired
	 public Discussion_GroupDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Discussion_Group> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		//create a query
		Query<Discussion_Group> theQuery =
				currentSession.createQuery("from Discussion_Group", Discussion_Group.class);
		
		List<Discussion_Group> discussion_Groups = theQuery.getResultList();

		return discussion_Groups;
	}

	@Override
	public List<Discussion_Group> findByUser(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
	
		
		return null;
	}

	@Override
	public List<Discussion_Group> findRecent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discussion_Group> findByTags(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion_Group findById(int theID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion_Group findByName(String theName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion_Group findByModerator(Moderator theModerator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDiscussion_Group(Discussion_Group theGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDiscussion_Group(Discussion_Group theGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(int theID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Discussion_Group discussion_Group) {
		// TODO Auto-generated method stub
		
	}

}
