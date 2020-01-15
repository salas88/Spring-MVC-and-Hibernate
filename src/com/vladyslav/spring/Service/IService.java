package com.vladyslav.spring.Service;

import java.util.List;

import com.vladyslav.spring.entity.User;

public interface IService {
	
	public List<User> getUsers();

	public void saveCustomer(User theUser);

	public User getOneUser(int theId);
}
