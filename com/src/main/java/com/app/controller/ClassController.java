package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ClassRequestDto;
import com.app.exceptions.NotFoundException;
import com.app.service.impl.UtilService;

@RestController
@RequestMapping("/classes")
public class ClassController {

	@Autowired
    private UtilService utilService;
	
	@PostMapping("/updateName")
	public ResponseEntity<Object> updateClassNameById(@RequestBody @Valid ClassRequestDto reqDto, BindingResult result) throws NotFoundException{
		 if (result.hasErrors()) {
	            return utilService.returnErrorMessages(result);
	        }
		return ResponseEntity.ok(utilService.updateClassNameById(reqDto));
	}

}
