package com.aamir.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aamir.dao.cartDao;
import com.aamir.model.Cart;
import com.aamir.model.Product;


@Component
public class CartDaoImpl implements cartDao
{
	@Autowired
	SessionFactory sessionFactory;

	public void addCart(Cart c) 
	{
		


		System.out.println("testing sessionfactory"+sessionFactory);
		Session session=sessionFactory.openSession();
		session.save(c);
		org.hibernate.Transaction t=session.beginTransaction();
		t.commit();
		session.close();
	}

	@Override
	public List<Cart> getCart() 
	{
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> cartlist=query.list();
		return cartlist;
	}

	@Override
	public Cart getProducts(int ProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	

		}
