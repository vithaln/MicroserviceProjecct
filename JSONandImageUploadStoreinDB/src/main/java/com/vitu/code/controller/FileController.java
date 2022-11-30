package com.vitu.code.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vitu.code.service.StorageService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private StorageService service;
	
	@PostMapping("/")
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) throws IOException{
		String uploadFiles = service.uploadFiles(file);
		
		return ResponseEntity.status(HttpStatus.OK).body(uploadFiles);
	}
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> dowonLoadImages(@PathVariable String fileName){
		byte[] downloadFiles = service.downloadFiles(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).
			
				body(downloadFiles);
	}
}
