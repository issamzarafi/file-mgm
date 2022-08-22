package com.test.files.mgm.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.files.mgm.entity.VacationAttachment;
import com.test.files.mgm.repository.AttachementRepository;
import com.test.files.mgm.service.AttachementService;

@Service
public class AttachementServiceImpl implements AttachementService{

	
	@Autowired
	private AttachementRepository attachementRepository;
	
	
	@Override
	public VacationAttachment save(MultipartFile file) throws IOException {
		VacationAttachment attachement=new VacationAttachment();
		attachement.setFileName(file.getOriginalFilename());
		attachement.setFileType(file.getContentType());
		attachement.setFileContent(file.getBytes());
		return attachementRepository.save(attachement);
	}


	@Override
	public VacationAttachment getById(Long fileId) throws Exception {
		return attachementRepository.findById(fileId)
				.orElseThrow(()->new Exception("File not found wit id: "+fileId));
	}

}
