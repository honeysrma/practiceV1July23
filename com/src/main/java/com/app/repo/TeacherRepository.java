package com.app.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    // You can define custom query methods here if needed.
    // Spring Data JPA will automatically generate queries based on the method names.

    // Example: Find Teacher entity by name
    Teacher findByName(String name);

    // Example: Find Teacher entities by subject
    List<Teacher> findBySubject(String subject);

    // Example: Find Teacher entities by specialization
    List<Teacher> findBySpecialization(String specialization);
}
