package com.app.entity;
import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classID")
    private int classID;

    @Column(name = "School", nullable = false)
    private String school;

    @Column(name = "class", nullable = false, length = 20)
    private String className;

    @Column(name = "section", length = 1)
    private String section;

    @Column(name = "subjects", length = 200)
    private String subjects;
    
    
    // Constructors, getters, and setters

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
    
}
