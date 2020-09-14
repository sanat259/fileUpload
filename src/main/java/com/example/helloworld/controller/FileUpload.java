package com.example.helloworld.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUpload {
	private Map<String, Object> result = new HashMap<>();
	
	public FileUpload() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/upload")
	public Map<String, Object> fileUpload(@RequestParam("attach") MultipartFile inputFile) throws IOException {
		
		//File info
		String fileName = inputFile.getOriginalFilename();
		String fileType = inputFile.getContentType();
		System.out.println("file details :" +fileName + fileType);
		result.put("Name", fileName);
		result.put("Type", fileType);
		
		//Save to Disk
		String filePath = "E:\\Java\\fileUpload\\Storage\\";
		inputFile.transferTo(new File(filePath+fileName));
		
		result.put("Success", true);
		
		return result;
		
	}

}
