package com.test.files.mgm.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vacation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5377972137614229241L;
	@Id
	//@SequenceGenerator(name = "seq_vacation",sequenceName = "seq_vacation")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate vacationDate;
	private Integer duration;
	@OneToMany(mappedBy = "vacation" , cascade = CascadeType.ALL)
	private List<VacationAttachment> attachmnets;
	
	public void addAttachment(VacationAttachment va) {
		if(this.attachmnets == null)
			attachmnets=new ArrayList<>();
	    attachmnets.add(va);	
	}
	

}
