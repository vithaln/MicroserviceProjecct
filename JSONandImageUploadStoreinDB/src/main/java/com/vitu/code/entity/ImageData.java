package com.vitu.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="image_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String imagaName;
	private String imageType;
	 @Lob
	 @Column(name = "imagedata",length = 1000)
	private byte[] imageData;
	 
	

}
