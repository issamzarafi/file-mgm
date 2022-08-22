package com.test.files.mgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.files.mgm.entity.Vacation;

public interface VacationRepository extends JpaRepository<Vacation,Long>{

}
