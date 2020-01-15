package com.vladyslav.spring.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vladyslav.spring.entity.User;

@Repository
public class DAOImplement implements IDAO{
	
	@Autowired
	private SessionFactory sessionFactoru;

	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactoru.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery("from User order by lastName", User.class);
		
		List<User> theList = theQuery.getResultList();
		
		return theList;
	}

	@Override
	public void saveUser(User theUser) {
		
		Session currentSession = sessionFactoru.getCurrentSession();
		
		currentSession.saveOrUpdate(theUser);
		
	}

	@Override
	public User getOneUser(int theId) {
		Session currentSession = sessionFactoru.getCurrentSession();
		
		User theUser = currentSession.get(User.class, theId);
		
		return theUser;
	}

	@Override
	public void deleteUser(int theId) {
		Session currentSession = sessionFactoru.getCurrentSession();
		
		Query<User> query = currentSession.createQuery("delete from User where id=:userId");
		
		query.setParameter("userId", theId);
		
		query.executeUpdate();
	}

	

}
