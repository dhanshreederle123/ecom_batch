package com.ecom.services;

import java.util.List;

import com.ecom.models.Product;

public interface ProductService {
	public Product createProduct(Product product);
	public Product updateProduct(Product newProduct,int productId);
	public void deleteProduct(int productId);
	public Product getProduct (int productId);
	public List<Product> getAllProducts();
	
	
	
	

}
