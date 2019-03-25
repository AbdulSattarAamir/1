package com.aamir.dao;

import java.util.List;

import com.aamir.model.Product;

public interface productDao 
{
	void addProduct(Product product);
List<Product> getProducts();
Product getProduct(int productId);
}
