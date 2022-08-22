package com.test.files.mgm.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.files.mgm.entity.Vacation;
import com.test.files.mgm.entity.VacationAttachment;
import com.test.files.mgm.entity.dto.VacationDTO;
import com.test.files.mgm.repository.AttachementRepository;
import com.test.files.mgm.repository.VacationRepository;
import com.test.files.mgm.service.VacationService;

@Service
public class VacationServiceImpl implements VacationService{

	@Autowired
	private VacationRepository vacationRepo;
	
	/*
	 * @Autowired private AttachementRepository attachementRepository;
	 */
	
	@Override
	public List<Vacation> getAll() {
		return vacationRepo.findAll();
	}

	@Override
	public Vacation add(VacationDTO vacDTO) throws Exception  {
		
		/*
		 * Vacation v =new Vacation(); v.setDuration(vacDTO.getDuration());
		 * v.setVacationDate(vacDTO.getVacationDate());
		 * 
		 * // save to db: Vacation addedV=vacationRepo.save(v); // add attachment:
		 * for(MultipartFile file:vacDTO.getFiles()) { VacationAttachment
		 * vacationAttachment=new VacationAttachment();
		 * vacationAttachment.setVacation(addedV);
		 * vacationAttachment.setFileName(file.getOriginalFilename());
		 * vacationAttachment.setFileType(file.getContentType());
		 * vacationAttachment.setFileContent(file.getBytes());
		 * attachementRepository.save(vacationAttachment);
		 * 
		 * }
		 */
		
		Vacation v =new Vacation();
		v.setDuration(vacDTO.getDuration());
		v.setVacationDate(vacDTO.getVacationDate());
		// add attachment:
		for(MultipartFile file:vacDTO.getFiles()) {
			VacationAttachment vacationAttachment=new VacationAttachment();
			vacationAttachment.setFileName(file.getOriginalFilename());
			vacationAttachment.setFileType(file.getContentType());
			try {
				vacationAttachment.setFileContent(file.getBytes());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception("Can't get file content!");
			}
			vacationAttachment.setVacation(v);
			v.addAttachment(vacationAttachment);
		}
		Vacation addedV=vacationRepo.save(v);
		return addedV;
	}

}
