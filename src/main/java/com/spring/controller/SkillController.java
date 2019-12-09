package com.spring.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.dto.Skills;
import com.spring.exception.SkillNotFoundException;
import com.spring.service.SkillServiceClass;

@RestController
@RequestMapping("skill")
public class SkillController {

	@Autowired
	SkillServiceClass ser;

	@GetMapping(path = "/getAllSkills")
	public List<Skills> findAllSkills() {
		return ser.findAllSkills();
	}

	@PostMapping(path = "/addSkills")
	public ResponseEntity<Skills> addSkills(@Valid @RequestBody Skills skill) throws Exception {
		Skills savedSkills = ser.addSkills(skill);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sId}")
				.buildAndExpand(savedSkills.getsId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/getSkill/{sId}")
	public Skills findOneSkill(@PathVariable int sId) {
		Skills skill = ser.findOneSkill(sId);
		if (skill.getsId() == 0)
			throw new SkillNotFoundException("Skill Not found with sId =" + sId);
		else
			return skill;

	}

	@DeleteMapping(path = "/deleteSkill/{sId}")
	public String deleteSkill(@PathVariable int sId) {
		Skills skill = ser.findOneSkill(sId);
		if (skill.getsId() == 0) {
			throw new SkillNotFoundException("Skill Not found with sId =" + sId);
		} else {
			ser.deleteSkill(sId);
			return "Skill deleted with sId "+sId;
		}
	}

	@PutMapping(path = "/updateSkill")
	public String updateSkill(@RequestBody Skills skill) {
		ser.updateSkill(skill);
		return "Skill updated with id "+skill.getsId();
	}

}
