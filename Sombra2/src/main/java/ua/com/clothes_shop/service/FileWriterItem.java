package ua.com.clothes_shop.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriterItem {
	
	enum Folder{
		CLOTHES
	}
	
	boolean write(Folder folder, MultipartFile file, int id);

}