package com.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dto.Skills;

@Repository
public interface SkillRepository extends JpaRepository<Skills, Integer> {

	Skills findSkillsByName(String sName);
	
}
