package com.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Abhishek.Das
 *
 */
@Entity
@Table(name = "Skills")
@NamedQuery(name="Skills.findSkillsByName",query="SELECT s FROM Skills s WHERE s.sName = :sName")
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

	@Override
	public String toString() {
		return "Skills [sId=" + sId + ", sName=" + sName + "]";
	}

	

}
