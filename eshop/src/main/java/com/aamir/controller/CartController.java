package com.aamir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aamir.dao.cartDao;
import com.aamir.dao.productDao;
import com.aamir.model.Cart;
import com.aamir.model.Product;

@Controller
public class CartController
{
	
	 @Autowired
	    cartDao cartdaoImpl;
	    
	    @Autowired
	    productDao pdao;
	    
	    
	@RequestMapping("/addtocart" )
	 public String addToCart()
	 {
		 System.out.println("hi");
	 	return "cart";
	 }
	
	@GetMapping("/addtocart")
	
	public  ModelAndView cart(@RequestParam("proid")int productId)
	{
		 {
		       System.out.println("cart");
		       Product p=pdao.getProduct(productId);
		       Cart c=new Cart();
		       c.setCartId((int)(Math.random()*10000));
		        c.setProductName(p.getProductName());
		        c.setProductPrice(p.getProductPrice());
		        c.setTotalPrice(p.getProductId());
		        c.setQuantity(1);
		        cartdaoImpl.addCart(c);
			    ModelAndView mv=new ModelAndView("cart","Cart",c);
		        return mv;

		   }
}
	
	
	@RequestMapping("/viewCart")
	ModelAndView viewCart()
	{
		
		List<Cart> cartListt=cartdaoImpl.getCart();
			
	ModelAndView mv=new ModelAndView("viewcart","cartList",cartListt);
	return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
