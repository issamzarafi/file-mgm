package com.test.files.mgm.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachementResponseDTO {
	
	private String fileName;
	private String url;
	private String fileType;
	private Long fileSize;

}
