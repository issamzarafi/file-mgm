package com.test.files.mgm.controller;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.files.mgm.entity.VacationAttachment;
import com.test.files.mgm.entity.dto.AttachementResponseDTO;
import com.test.files.mgm.service.AttachementService;

@RestController
@RequestMapping("/api/files")
public class AttachementController {
	
	private AttachementService attachementService;
	
	public AttachementController(AttachementService attachementService) {
		this.attachementService =attachementService;
	}
	
	@PostMapping("/upload")
	public AttachementResponseDTO addAttachement(@RequestParam("file") MultipartFile file) throws IOException {
		attachementService.save(file);
		return new AttachementResponseDTO();
	}
	
	@GetMapping("/download/file/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("fileId") Long fileId) throws Exception{
		VacationAttachment attachement = attachementService.getById(fileId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(attachement.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+attachement.getFileName()+"\"")
				.body(new ByteArrayResource(attachement.streamFileContentData()));
				
				
	}

}
