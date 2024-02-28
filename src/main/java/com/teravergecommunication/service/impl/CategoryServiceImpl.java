package com.teravergecommunication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teravergecommunication.entity.Category;
import com.teravergecommunication.pojo.CategoryDto;
import com.teravergecommunication.repo.CategoryRepo;
import com.teravergecommunication.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category = this.toCategory(categoryDto);
		Category saved = categoryRepo.save(category);
		return this.toDto(saved);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> findAll = categoryRepo.findAll();
		List<CategoryDto> allCategory = findAll.stream().map((e)->this.toDto(e)).collect(Collectors.toList());
		return allCategory;
	}
	
	//  mapper methods 
	
	private CategoryDto toDto(Category category) {
		return  modelMapper.map(category, CategoryDto.class);
	}
	private Category toCategory(CategoryDto categoryDto) {
		return  modelMapper.map(categoryDto, Category.class);
	}

}
