package com.aamir.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

	import com.aamir.dao.productDao;
	import com.aamir.model.Product;

	@Controller
	public class ProductController 
	{
		@Autowired
		productDao daoImpl;
		
		@RequestMapping("/Products")
		public ModelAndView goToForm()
		{
			ModelAndView mv=new ModelAndView("Products");
			mv.addObject("pr",new Product());
			return mv;
		}
		
		@RequestMapping("/adminhome")
		public String adminhome()
		{
			return "adminhome";
			
			
		}

		@RequestMapping(value="/addProduct",method=RequestMethod.POST)

			public String saveProduct(@ModelAttribute("pr") Product pro)
			{
			
				System.out.println(pro.getProductId());
				System.out.println(pro.getProductName());
				System.out.println(pro.getProductPrice());
				daoImpl.addProduct(pro);
				
				MultipartFile image=pro.getImage();

				try {
					byte imageInbytes[] =image.getBytes();
				
				
				// ?
				String path="C:\\Users\\pc\\eclipse-workspace\\eshop\\src\\main\\webapp\\resources\\proimg";
				
				path=path+pro.getProductId()+".png";
				// ?
				System.out.println("img---------------"+image);
				if(image!=null)
				{
					System.out.println("img---------------"+image);
					File file=new File(path);
					FileOutputStream  fos=new FileOutputStream(file);
					BufferedOutputStream  bos=new BufferedOutputStream(fos);
					bos.write(imageInbytes);
					bos.close();			
				}
				}
				 catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				return "addProduct";
			}

//////as of 25.1.2019 we have changed line 
	
////ModelAndView mv=new ModelAndView("guesthome","product",productlist);
///previously it was viewsproducts in place of guesthome.To GET THE DATA FROM DB
///WE HAVE ALSO CHANGED WEB.XML WELCOMEFILE LIST TO guesthome.
///Previously it was only URL"/"
		
		//code for getting the all results from db
		@RequestMapping("/v")
		public ModelAndView getProducts()
		{
			List<Product> productlist=daoImpl.getProducts();
			//viewproducts is jsp page,product is variable holding productlist.
			//product variable should be passed to viewproducts.jsp in foreachloop.
			ModelAndView mv=new ModelAndView("viewproducts","product",productlist);
			
			//mv.addObject(productlist);
			//System.out.println(productlist);
			return mv;
		}
		
		
		/*@GetMapping("/viewproducts")
		public  ModelAndView showAllProduct(@RequestParam("proid") int productId)		{
			List<Product> productlist=daoImpl.getProducts();
			ModelAndView mv=new ModelAndView("single","product",productId);
            return mv;
		}
		*/
		
		
		
		@RequestMapping("/viewdetails")
				public ModelAndView goToSingle()
		{
			ModelAndView mv=new ModelAndView("single");
		return mv;
	}
		
		
		
		@RequestMapping("/viewproducts")
		
		public  ModelAndView showSingleProduct(@RequestParam("proid")int productId)
		{
			Product product=new Product();
          product=daoImpl.getProduct(productId);
          
          System.out.println(product.getProductName());
          ModelAndView mv=new ModelAndView("single","p",product);
          return mv;
	}
	
		
		
		
		
		
		}
	
	
	
	