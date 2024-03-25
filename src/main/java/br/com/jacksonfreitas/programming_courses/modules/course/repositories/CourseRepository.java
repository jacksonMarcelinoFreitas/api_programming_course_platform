package br.com.jacksonfreitas.programming_courses.modules.course.repositories;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jacksonfreitas.programming_courses.modules.course.entities.CourseEntity;


public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{

    Optional<CourseEntity> findByName(String name); //usado no create

    Optional<CourseEntity> findById(UUID id); //usado no list one

    List<CourseEntity> findAll(); //usado no list 

    void deleteById(UUID id);
    
} 