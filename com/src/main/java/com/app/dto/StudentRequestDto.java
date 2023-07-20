package com.app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentRequestDto {

	@Min(1)
    private int studentID;
	
	@NotBlank
    @Size(min = 2, max = 100)
    private String name;
    
	public StudentRequestDto() {
		super();
	}

	public StudentRequestDto(int studentID, String name) {
		super();
		this.studentID = studentID;
		this.name = name;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
