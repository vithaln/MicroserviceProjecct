package com.vitu.code.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitu.code.USer;

@RestController
@RequestMapping("/user")
public class UserController {

	private Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private ObjectMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> createUser(
@RequestParam("user") String  userData,
@RequestParam("files") MultipartFile[] files
			
			){
		
		logger.info("Files information name is  {}  ",files.length);
		logger.info(" file type is {}",files.length);
		logger.info("user added" );
		
		Arrays.stream(files).forEach(mulFile->{
				
				logger.info("file name is {} ",mulFile.getOriginalFilename());
			//	logger.info("file type id  {} ",mulFile.ge)
				logger.info("file type {} " ,mulFile.getContentType());
		}
				);
		
		//logger.info("user {} added",userData);
		USer user=null;
	try {
		 user=	mapper.readValue(userData, USer.class);
	} 
		
	 catch (JsonProcessingException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid data");
	} 
		
	logger.info("{} added",user);
		return ResponseEntity.ok("User has been created..");
	}
}
