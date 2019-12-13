package com.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skills {

	@Id
	private int sId;
	
	private String sName;

	public Skills() {
	}

	public int getsId() {
		return sId; 
	} 

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	

}
