 package com.aamir.controller;

import org.hibernate.boot.spi.AdditionalJaxbMappingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aamir.daoimpl.ProductDaoImpl;
import com.aamir.model.Category;
import com.aamir.model.Product;
import com.aamir.model.User;
import com.aamir.*;
import com.aamir.dao.productDao;
import com.aamir.dao.userDao;

	@Controller
	public class HomeController
	{	
		@Autowired
		userDao userDao;
		
		
		@Autowired 
		productDao daoImpl;
	
		HomeController()
		{
			System.out.println("check the controller class");
		}

@RequestMapping("/Home")
		
		String h()
		{			
		//ProductDaoImpl daoImpl=new ProductDaoImpl();
		daoImpl.addProduct(new Product());
		
		return "adminhome";
		}

@RequestMapping("/Register")
public ModelAndView register()
{
	ModelAndView mv=new ModelAndView("Register");
	mv.addObject("user",new User());
	return mv;
}

@RequestMapping(value="/addUser",method=RequestMethod.POST)
public String getUser(@ModelAttribute("user")User user)
{	
	
	System.out.println(user.getEmail());
	System.out.println(user.getMobile());
	System.out.println(user.getPassword());
	System.out.println(user.getRole());
	
	
	
userDao.addUser(user);


 return "redirect:/";

}
 
 

	}

