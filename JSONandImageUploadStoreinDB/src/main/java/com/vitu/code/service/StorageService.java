package com.vitu.code.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vitu.code.entity.ImageData;
import com.vitu.code.repository.StorageRepository;
import com.vitu.code.util.ImageUtils;

import lombok.Setter;

@Service
public class StorageService {
	
	@Autowired
	private StorageRepository repo;
	
	public String uploadFiles(MultipartFile file) throws IOException {
		ImageData savedFile = repo.save(ImageData.builder()
				.imagaName(file.getOriginalFilename())
				.imageType(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
		
		if(savedFile!=null) {
			return "file uploaded succesfully "+file.getOriginalFilename() +"and file type is "+file.getContentType();
		}
		else {
			return null;
		}
	}
	
	public byte[] downloadFiles(String fileName) {
			
		Optional<ImageData> dbfiles = repo.findByfileName(fileName);
		byte[] decompressImage = ImageUtils.decompressImage(dbfiles.get().getImageData());
		return decompressImage;
	}

}
