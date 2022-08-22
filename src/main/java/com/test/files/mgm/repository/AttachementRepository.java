package com.test.files.mgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.files.mgm.entity.VacationAttachment;

@Repository
public interface AttachementRepository extends JpaRepository<VacationAttachment, Long>{

}
