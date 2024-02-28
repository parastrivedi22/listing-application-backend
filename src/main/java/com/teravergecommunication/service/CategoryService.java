package com.teravergecommunication.service;

import java.util.List;

import com.teravergecommunication.pojo.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategory(CategoryDto categoryDto);
	public List<CategoryDto> getAllCategory();
	
}
