package com.teravergecommunication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teravergecommunication.entity.Product;
import com.teravergecommunication.expection.MediaNotSupportException;
import com.teravergecommunication.expection.ResourceNotFoundException;
import com.teravergecommunication.pojo.ProductDto;
import com.teravergecommunication.repo.ProductRepo;
import com.teravergecommunication.service.ProductService;
import com.teravergecommunication.util.ImageHandler;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ImageHandler imageHandler;

	@Override
	public ProductDto createProduct(MultipartFile file, String productDto) {
		if (file == null || file.isEmpty()) {
			throw new MediaNotSupportException(file.getContentType(), "media should be image");
		}

		try {

			ProductDto dto = objectMapper.readValue(productDto, ProductDto.class);
			dto.setImageUrl(imageHandler.saveImageInDir(file));
			Product product = this.toProduct(dto);
			Product saved = productRepo.save(product);
			return this.toDto(saved);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public ProductDto getProductById(Integer id) {
		// TODO Auto-generated method stub
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		return this.toDto(product);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> findAll = productRepo.findAll();
		List<ProductDto> products = findAll.stream().map((product) -> this.toDto(product)).collect(Collectors.toList());
		return products;
	}

	@Override
	public List<ProductDto> getProductByCategory(String category) {
//		// TODO Auto-generated method stub
		List<Product> findAll = productRepo.findByCategory(category);

		List<ProductDto> products = findAll.stream().map((product) -> this.toDto(product)).collect(Collectors.toList());
		return products;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepo.delete(product);
	}

	@Override
	public List<ProductDto> getSimilarProducts(String keyword, String category) {
		if(!keyword.isBlank()) {
			String keyworys[] = keyword.split(",\\s*");
			for (String searchKey : keyworys) {
				List<Product> products = productRepo.findByKeywordsContaining(searchKey);
				if (products != null && !products.isEmpty()) {
					List<ProductDto> productDto = products.stream().map((product) -> this.toDto(product))
							.collect(Collectors.toList());
					return productDto;
				}
			}
		}
		return this.getProductByCategory(category);
	}

//  mapper methods 

	private ProductDto toDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}

	private Product toProduct(ProductDto productDto) {
		return modelMapper.map(productDto, Product.class);
	}

}
