package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.repo.StudentSubjectRepository;

@RestController
@RequestMapping("/student_subjects")
public class StudentSubjectController {

    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

}
