package com.app.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.app.dto.ClassRequestDto;
import com.app.dto.StudentRequestDto;
import com.app.dto.TeacherRequestDto;
import com.app.entity.Class;
import com.app.entity.Student;
import com.app.entity.Teacher;
import com.app.exceptions.NotFoundException;

public interface UtilService {

	Teacher getTeacherStudentListDetailsById(int id) throws NotFoundException;

	Student updateStudentNameById(StudentRequestDto reqDto) throws NotFoundException;

	Class updateClassNameById(ClassRequestDto reqDto) throws NotFoundException;

	Teacher updateTeacherNameById(TeacherRequestDto reqDto) throws NotFoundException;

	ResponseEntity<Object> returnErrorMessages(BindingResult result);

}
