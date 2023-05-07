package com.ecommerce.EcommerceApi.dao;

import com.ecommerce.EcommerceApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {

}
