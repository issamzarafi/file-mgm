package com.test.files.mgm.entity.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class VacationDTO {
	
	private Long id;
	private LocalDate vacationDate;
	private Integer duration;
	MultipartFile[] files;

}
