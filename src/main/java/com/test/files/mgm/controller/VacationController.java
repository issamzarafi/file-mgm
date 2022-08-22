package com.test.files.mgm.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.files.mgm.entity.Vacation;
import com.test.files.mgm.entity.dto.VacationDTO;
import com.test.files.mgm.service.VacationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/vacations")
public class VacationController {

	
	@Autowired
	private VacationService vacationService; 
	
	@GetMapping("/all")
	public List<Vacation> getAllVacatios(){
		return vacationService.getAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> addVacation(@RequestParam("vacationDate") String date,@RequestParam("duration") Integer duration,@RequestParam("files") MultipartFile[] files) throws Exception {
		 VacationDTO vacDTO=new VacationDTO();
		 vacDTO.setVacationDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("d-MM-yyyy")));
		 vacDTO.setDuration(duration);
		 vacDTO.setFiles(files);
		log.info("Files array size: {} ",vacDTO.getFiles().length);
		Vacation v=null;
	    
		v=	vacationService.add(vacDTO);
		
	    log.info("*****************************");
	    return ResponseEntity.ok(v);
	}
	
	
}
