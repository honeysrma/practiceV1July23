package com.app.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // You can define custom query methods here if needed.
    // Spring Data JPA will automatically generate queries based on the method names.

    // Example: Find Student entity by name
    Student findByName(String name);

    // Example: Find Student entities by age
    List<Student> findByAge(int age);

    // Example: Find Student entities by gender
    List<Student> findByGender(Student.Gender gender);

    // Example: Find Student entities by address
    List<Student> findByAddress(String address);
    
    
}
