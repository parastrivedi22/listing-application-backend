package com.teravergecommunication.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ImageHandler {

//	 private final static  String DIR ="D:\\Telaverge Comm  Task\\feature-branch\\src\\main\\resources\\static\\product_image";		
	 private final  String DIRr = new ClassPathResource("/static/product_image/").getFile().getAbsolutePath();
	 private String uuid = ""+(Math.round(Math.random()*1000000));
	public ImageHandler() throws Exception {}
	
	public String saveImageInDir(MultipartFile file) {
		if(file == null || file.isEmpty()) {
			return null;
		}
		
		try {
			
			String filePath = DIRr+File.separator+uuid+file.getOriginalFilename();
			Files.copy(file.getInputStream(), Paths.get(filePath),StandardCopyOption.REPLACE_EXISTING);

			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/product_image/")
				.path(uuid+file.getOriginalFilename()).toUriString();
		
		
			
	}
}
