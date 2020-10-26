package com.gorun.demo.dto;

import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class ImageDTO {
	
	@JsonPropertyDescription
	@Transient
	private MultipartFile file;
	private int id;
	
	public ImageDTO(MultipartFile file, int id) {
		super();
		this.file = file;
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ImageDTO [file=" + file + ", id=" + id + "]";
	}
	
	

}
