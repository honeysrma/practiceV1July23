package com.app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClassRequestDto {

	@Min(value = 1, message = "Id must greater than 0")
	private int classID;
	
	@NotBlank
    @Size(min = 2, max = 20, message = "Invalid Class Name Value")
	private String className;
	
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
    
	
}
