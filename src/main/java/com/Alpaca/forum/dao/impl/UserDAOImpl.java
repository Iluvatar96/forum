package com.Alpaca.forum.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.Alpaca.forum.dao.UserDAO;
import com.Alpaca.forum.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private EntityManager entityManager;
	
	
	
	public UserDAOImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}

	@Override
	public List<User> findAll() {
		
		//get the current Hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				
				//create a query
				Query<User> theQuery =
						currentSession.createQuery("from User", User.class);
				
				List<User> users = theQuery.getResultList();
		
		return users;
	}

		@Override
		public User findById(int theID) {
			
			Session currentSession = entityManager.unwrap(Session.class);
			
			User theUser = 
					currentSession.get(User.class, theID);
			return theUser;
			
		}



	@Override
	public void deleteByID(int theID) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = 
				currentSession.createQuery("delete from User where user_id=:user_id" );
		theQuery.setParameter("user_id", theID);
		theQuery.executeUpdate();
	}

	@Override
	public void updateUser(User theUser) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(theUser);
	}

	@Override
	public void addUser(User theUser) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theUser);
	}

	@Override
	public User findByUsername(String username) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = 
				currentSession.get(User.class, username);
		return theUser;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = 
				currentSession.get(User.class, email);
		return theUser;
	}

}
