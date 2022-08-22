package com.test.files.mgm.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.test.files.mgm.entity.VacationAttachment;

public interface AttachementService {

	VacationAttachment save(MultipartFile file) throws IOException;

	VacationAttachment getById(Long fileId) throws Exception;
}
