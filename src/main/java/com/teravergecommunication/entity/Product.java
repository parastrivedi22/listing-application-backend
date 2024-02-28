package com.teravergecommunication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

  
@Entity
@Table(name="products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(length=1000)
    private String productName;
    @Column(length=5000)
    private String productDescription;
    private Double price;
    @Column(length=1000)
    private String category;
    private String keywords;
    @Column(length=3000)
    private String imageUrl;

  }