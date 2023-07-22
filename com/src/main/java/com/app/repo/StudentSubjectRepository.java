package com.app.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {

    List<StudentSubject> findAllByStudentStudentID(int studentID);

    List<StudentSubject> findAllByClassObjClassID(int classID);

    List<StudentSubject> findAllByTeacherTeacherID(int teacherID);
    
    @Query(value= "select * from student_subject ss where ss.teacherID=:teacherID LIMIT 1", nativeQuery = true)
    StudentSubject findOneByTeacherID(@Param("teacherID")int teacherID);
    
    @Query(value= "select * from student_subject ss where ss.studentID=:studentID LIMIT 1", nativeQuery = true)
    StudentSubject findOneByStudentID(@Param("studentID")int studentID);
   
    @Query(value= "select * from student_subject ss where ss.classID=:classID LIMIT 1", nativeQuery = true)
    StudentSubject findOneByClassID(@Param("classID")int classID);
   
    
}
