package com.teravergecommunication.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.teravergecommunication.pojo.ProductDto;

public interface ProductService {

	ProductDto createProduct(MultipartFile file, String productDto);
	ProductDto getProductById(Integer id);
	List<ProductDto>getAllProducts();
	List<ProductDto>getProductByCategory(String category);
	List<ProductDto>getSimilarProducts(String keywords, String category);
	

	void deleteProduct(Integer id);
}
