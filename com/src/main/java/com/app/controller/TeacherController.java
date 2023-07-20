package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TeacherRequestDto;
import com.app.entity.Teacher;
import com.app.exceptions.NotFoundException;
import com.app.service.impl.UtilService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private UtilService utilService;

	@GetMapping(path = "/id/{id}")
	public Teacher getTeacherStudentListDetailsById(@PathVariable(name = "id") Integer id) throws NotFoundException {
		return utilService.getTeacherStudentListDetailsById(id);
	}

	@PostMapping("/updateName")
	public ResponseEntity<Object> updateTeacherNameById(@RequestBody @Valid TeacherRequestDto reqDto,
			BindingResult result) throws NotFoundException {
		if (result.hasErrors()) {
			return utilService.returnErrorMessages(result);
		}
		return ResponseEntity.ok(utilService.updateTeacherNameById(reqDto));
	}

}
