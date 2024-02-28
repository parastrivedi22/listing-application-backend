package com.teravergecommunication.pojo;

import lombok.Data;

@Data
public class ProductDto {
	    private Integer productId;
	    private String productName;
	    private String productDescription;
	    private Double price;
	    private String category;
	    private String keywords;
	    private String imageUrl;
}
