package com.aamir.dao;

import java.util.List;

import com.aamir.model.Cart;

public interface cartDao 
{

void addCart(Cart c);
List<Cart> getCart();
Cart getProducts(int ProductId);
}
