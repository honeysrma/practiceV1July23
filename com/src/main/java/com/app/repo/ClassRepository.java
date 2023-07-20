package com.app.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entity.Class;
@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    // You can define custom query methods here if needed.
    // Spring Data JPA will automatically generate queries based on the method names.

    // Example: Find Class entity by school name
    List<Class> findBySchool(String school);

    // Example: Find Class entities by class name
    List<Class> findByClassName(String className);

    // Example: Find Class entities by section
    List<Class> findBySection(String section);
}
