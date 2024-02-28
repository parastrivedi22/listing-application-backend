package com.teravergecommunication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.teravergecommunication.pojo.ApiResponse;
import com.teravergecommunication.pojo.ProductDto;
import com.teravergecommunication.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/create")
	public ResponseEntity<ProductDto> createCategory(@RequestParam("file") MultipartFile file , 
			@RequestParam("productDto") String productDto) {
		
		ProductDto product = productService.createProduct(file, productDto);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> allProducts = productService.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@GetMapping("/by")
	public ResponseEntity<List<ProductDto>> getProductByCategory(
			@RequestParam(value = "category", defaultValue = "grocery", required = false) String category) {
		List<ProductDto> allProducts = productService.getProductByCategory(category);
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}


	@GetMapping("/search")
	public ResponseEntity<List<ProductDto>> getSimilarProduct(
			@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword,
			@RequestParam(value = "category", defaultValue = "all", required = false) String category) {
		List<ProductDto> allProducts = productService.getSimilarProducts(keyword, category);
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {
		ProductDto product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	

	
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ApiResponse("", true);
	}
}
