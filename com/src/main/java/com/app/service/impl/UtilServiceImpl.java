package com.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.ClassRequestDto;
import com.app.dto.StudentRequestDto;
import com.app.dto.TeacherRequestDto;
import com.app.entity.Class;
import com.app.entity.Student;
import com.app.entity.StudentSubject;
import com.app.entity.Teacher;
import com.app.exceptions.NotFoundException;
import com.app.repo.ClassRepository;
import com.app.repo.StudentRepository;
import com.app.repo.StudentSubjectRepository;
import com.app.repo.TeacherRepository;

@Service
public class UtilServiceImpl implements UtilService {

	 	@Autowired
	    private TeacherRepository teacherRepository;
	 	@Autowired
	    private StudentSubjectRepository studentSubjectRepository;
	 	@Autowired
	    private ClassRepository classRepository;
	 	@Autowired
	    private StudentRepository studentRepository;
	 	
	 	@Override
	 	public Teacher getTeacherStudentListDetailsById(int id) throws NotFoundException {
	 		Teacher teacher = new Teacher();
	 		List<StudentSubject> ssList = studentSubjectRepository.findAllByTeacherTeacherID(id);
	 		if(CollectionUtils.isEmpty(ssList)) {
	 			throw new NotFoundException("id - "+ id);
	 		}
	 		teacher=ssList.stream().map(e->e.getTeacher()).findFirst().get();
			teacher.setStudentList(ssList.stream().map(e -> {
				e.getStudent().setClassObj(e.getClassObj());
				return e.getStudent();
			}).collect(Collectors.toList()));
	 		return teacher;
	 	}
	 	
	 	@Override
	 	public Student updateStudentNameById(@RequestBody StudentRequestDto reqDto) throws NotFoundException {
	 		List<StudentSubject> studentList= studentSubjectRepository.findAllByStudentStudentID(reqDto.getStudentID());
	 		if(CollectionUtils.isEmpty(studentList)) {
	 			throw new NotFoundException("id - "+ reqDto.getStudentID());
	 		}
	 		Student s= studentList.get(0).getStudent();
	 		s.setName(reqDto.getName());
	 		studentRepository.save(s);
	 		return s;
	 	}
	 	
	 	@Override
	 	public Class updateClassNameById(@RequestBody ClassRequestDto reqDto) throws NotFoundException {
	 		List<StudentSubject> ssList= studentSubjectRepository.findAllByClassObjClassID(reqDto.getClassID());
	 		if(CollectionUtils.isEmpty(ssList)) {
	 			throw new NotFoundException("id - "+ reqDto.getClassID());
	 		}
	 		Class c= ssList.get(0).getClassObj();
	 		c.setClassName(reqDto.getClassName());
	 		classRepository.save(c);
	 		return c;
	 	}
	 	
	 	@Override
	 	public Teacher updateTeacherNameById(@RequestBody TeacherRequestDto reqDto) throws NotFoundException {
	 		List<StudentSubject> ssList= studentSubjectRepository.findAllByTeacherTeacherID(reqDto.getTeacherID());
	 		if(CollectionUtils.isEmpty(ssList)) {
	 			throw new NotFoundException("id - "+ reqDto.getTeacherID());
	 		}
	 		Teacher t= ssList.get(0).getTeacher();
	 		t.setName(reqDto.getName());
	 		teacherRepository.save(t);
	 		return t;
	 	}
	 	
	 	@Override
	 	public ResponseEntity<Object> returnErrorMessages(BindingResult result){
	 		 Map<String, String> errors = new HashMap<>();
	            for (FieldError error : result.getFieldErrors()) {
	                errors.put(error.getField(), error.getDefaultMessage());
	            }
	            return ResponseEntity.badRequest().body(errors);
	 	}
	 
}
