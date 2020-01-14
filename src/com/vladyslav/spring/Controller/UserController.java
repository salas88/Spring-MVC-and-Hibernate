package com.vladyslav.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vladyslav.spring.DAO.IDAO;
import com.vladyslav.spring.Service.IService;
import com.vladyslav.spring.entity.User;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IService iService;
	
	
	@RequestMapping("/list")
	public String showPage(Model theModel) {
		
		List<User> users = iService.getUsers();
		
		theModel.addAttribute("users", users);
		
		return "users-list";
	}

}
