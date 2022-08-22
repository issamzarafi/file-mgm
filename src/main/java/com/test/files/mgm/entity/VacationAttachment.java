package com.test.files.mgm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VacationAttachment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1535189457570092126L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fileName;
	private String fileType;
	
	@Lob
	@Getter(value = AccessLevel.NONE)
	private byte[] fileContent;
	@ManyToOne 
	@JoinColumn(name = "vacation_id",nullable = false)
	@JsonIgnore
	private Vacation vacation;
	
	public byte[] streamFileContentData() {
		return this.fileContent;
	}
}
