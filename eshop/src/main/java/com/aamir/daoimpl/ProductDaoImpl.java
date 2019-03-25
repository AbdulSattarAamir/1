package com.aamir.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aamir.dao.productDao;
import com.aamir.model.Product;

@Component
public class ProductDaoImpl implements productDao
{
@Autowired
SessionFactory sessionFactory;

public void addProduct(Product product)

{
	System.out.println("testing sessionfactory"+sessionFactory);

Session session=sessionFactory.openSession();
product.setProductId((int)(Math.random()*10000));

session.save(product);
Transaction t=session.beginTransaction();
t.commit();

session.close();
}

public List<Product> getProducts()
{
	Session session=sessionFactory.openSession();
Query query=session.createQuery("from Product");
List<Product> proList = query.list();        
return proList;
}


public Product getProduct(int ProductId)
{
	Session session=sessionFactory.openSession();
	Product p=new Product();
p=session.get(Product.class, ProductId);
org.hibernate.Transaction t=session.beginTransaction();
t.commit();
return p;

}
}
