package com.ecom.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ecom.models.Product;
@Service
public class ProductServiceImpl implements ProductService {
	//storage 
	List<Product>list=new  ArrayList<>();
	
    //creating a product
	@Override
	public Product createProduct(Product product) {
		System.out.println(product.getProductName());
		list.add(product);
		return product;
	}
    //update
	@Override
	public Product updateProduct(Product newProduct, int productId) {
		List<Product> updateList = list.stream().map(p-> {
			if(p.getProductId()==productId) {
				//update p return
				p.setProductName(newProduct.getProductName());
				p.setProductPrice(newProduct.getProductPrice());
				p.setProductDesc(newProduct.getProductDesc());
				p.setStock(newProduct.isStock());
				
		        return p;
		        }else {
		        	return p;
		        }
		}).collect(Collectors.toList());
		list=updateList;
		newProduct.setProductId(productId);
		return newProduct;
		}

	@Override
	public void deleteProduct(int productId) {
		String query ="delete from product where product_id=?";
		int deleted =jdbcTemplate.update(query,productId);
		System.out.println(deleted+"row deleted");
	
		
	}

	@Override
	public Product getProduct(int productId) {
		String query ="select * from product where product_id=?";
        jdbcTemplate.queryForObject(query,new RowMapper<Product>()
        		{
        	public Product mapRow(ResultSet rs,int rowNum)throws SQLException{
        		Product p=new Product();
        		p.setProductId();
        	}
        		},productId)
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
