package com.teravergecommunication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teravergecommunication.pojo.CategoryDto;
import com.teravergecommunication.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto createCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return new ResponseEntity<>(allCategory, HttpStatus.OK);
	}
}
