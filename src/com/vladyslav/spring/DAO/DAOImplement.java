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
	@Transactional
	public List<User> getUsers() {
		
		Session currentSession = sessionFactoru.getCurrentSession();
		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		
		List<User> theList = theQuery.getResultList();
		
		return theList;
	}

}
