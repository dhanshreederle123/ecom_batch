package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.models.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
