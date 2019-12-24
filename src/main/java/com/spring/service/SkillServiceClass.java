package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Skills;
import com.spring.exception.SkillNotFoundException;
import com.spring.repository.SkillRepository;

@Service
public class SkillServiceClass {

	@Autowired
	SkillRepository repo;

	public List<Skills> findAllSkills() {
		
		List<Skills> skills= repo.findAll();
		if(skills.isEmpty())
		{
			throw new SkillNotFoundException("Skill not found");
		}
		return skills;
	}

	public Skills addSkills(Skills skill) {
		return repo.save(skill);
	}

	public Skills findOneSkill(int sId) {
		Optional<Skills> skillOptional = repo.findById(sId);
		if (skillOptional.isPresent()) {
			return skillOptional.get();
		} else {
			throw new SkillNotFoundException("Skill Not found with id= "+sId);
		}
	}

	public Skills findSkillsByName(String sName) {
		return repo.findSkillsByName(sName);

	}

	public void deleteSkill(int sId) {
		Optional<Skills> skillOptional = repo.findById(sId);
		if (skillOptional.isPresent()) {
		repo.deleteById(sId);
		}
		else {
			throw new SkillNotFoundException("Skill Not found with id= "+sId);
		}
	}

	public Skills updateSkill(Skills skill) {
		Skills savedSkills = new Skills();
		Optional<Skills> skillOptional = repo.findById(skill.getsId());
		if (skillOptional.isPresent()) {
			savedSkills = skillOptional.get();
			savedSkills.setsName(skill.getsName());
			repo.save(savedSkills);
		}
		return savedSkills;

	}

}
