package com.teravergecommunication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teravergecommunication.entity.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer>{
}
