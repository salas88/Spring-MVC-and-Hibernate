package com.vladyslav.spring.DAO;

import java.util.List;

import com.vladyslav.spring.entity.User;

public interface IDAO {
	
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getOneUser(int theId);

	public void deleteUser(int theId);



}
