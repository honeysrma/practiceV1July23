package com.app.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
    // You can define custom query methods here if needed.
    // Spring Data JPA will automatically generate queries based on the method names.

    // Example: Get all StudentSubject entities by studentID
    List<StudentSubject> findAllByStudentStudentID(int studentID);

    // Example: Get all StudentSubject entities by classID
    List<StudentSubject> findAllByClassObjClassID(int classID);

    // Example: Get all StudentSubject entities by teacherID
    List<StudentSubject> findAllByTeacherTeacherID(int teacherID);
}
