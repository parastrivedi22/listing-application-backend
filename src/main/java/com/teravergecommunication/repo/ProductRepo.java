package com.teravergecommunication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teravergecommunication.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
		public List<Product> findByCategory(String category);
		public List<Product> findByKeywordsContaining(String title);
}
