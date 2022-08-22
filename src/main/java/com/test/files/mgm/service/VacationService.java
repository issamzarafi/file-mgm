package com.test.files.mgm.service;

import java.io.IOException;
import java.util.List;

import com.test.files.mgm.entity.Vacation;
import com.test.files.mgm.entity.dto.VacationDTO;

public interface VacationService {
	
	List<Vacation> getAll();
	Vacation add(VacationDTO vacDTO) throws IOException, Exception;

}
