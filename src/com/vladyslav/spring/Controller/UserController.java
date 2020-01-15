package com.vladyslav.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "form-new-user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		iService.saveCustomer(theUser);
		return "redirect:/users/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
		
		User theUser = iService.getOneUser(theId);
		theModel.addAttribute("user", theUser);
		
		return "form-new-user";
	}

}
