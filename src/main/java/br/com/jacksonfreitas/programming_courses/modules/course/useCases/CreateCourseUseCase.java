package br.com.jacksonfreitas.programming_courses.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jacksonfreitas.programming_courses.exceptions.CourseFoundException;
import br.com.jacksonfreitas.programming_courses.modules.course.entities.CourseEntity;
import br.com.jacksonfreitas.programming_courses.modules.course.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {
    
    @Autowired
    private CourseRepository courseRepository;
    
    public CourseEntity execute(CourseEntity courseEntity){
        this.courseRepository
        .findByName(courseEntity.getName())
        .ifPresent((course) -> {
            throw new CourseFoundException();
        });
        return this.courseRepository.save(courseEntity);
    }
}
