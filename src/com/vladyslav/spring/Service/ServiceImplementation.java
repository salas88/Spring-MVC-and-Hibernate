package com.vladyslav.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vladyslav.spring.DAO.IDAO;
import com.vladyslav.spring.entity.User;

@Service
public class ServiceImplementation implements IService {
	
	@Autowired
	private IDAO iDao;
	
	@Transactional
	public List<User> getUsers() {
		
		return iDao.getUsers();
				
	}

	@Override
	@Transactional
	public void saveCustomer(User theUser) {
		
		iDao.saveUser(theUser);
		
	}

	

}
