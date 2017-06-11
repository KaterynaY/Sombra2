package ua.com.clothes_shop.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {
	
	enum Folder{
		COLOR 
	}
	
	boolean write(Folder folder, MultipartFile file, int id);

}
