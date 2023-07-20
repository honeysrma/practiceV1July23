package com.app.entity;
import javax.persistence.*;

@Entity
@Table(name = "student_subject")
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_subjectID")
    private int studentSubjectID;

    @ManyToOne
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "classID", referencedColumnName = "classID")
    private Class classObj;

    @ManyToOne
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    private Teacher teacher;

	public int getStudentSubjectID() {
		return studentSubjectID;
	}

	public void setStudentSubjectID(int studentSubjectID) {
		this.studentSubjectID = studentSubjectID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Class getClassObj() {
		return classObj;
	}

	public void setClassObj(Class classObj) {
		this.classObj = classObj;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
