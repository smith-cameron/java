package com.cameronsmith.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.productsandcategories.models.Category;
import com.cameronsmith.productsandcategories.models.Product;
@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
