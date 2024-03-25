package br.com.jacksonfreitas.programming_courses.modules.course.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jacksonfreitas.programming_courses.exceptions.CourseNotFoundException;
import br.com.jacksonfreitas.programming_courses.modules.course.entities.CourseEntity;
import br.com.jacksonfreitas.programming_courses.modules.course.repositories.CourseRepository;

@Service
public class ShowCourseUseCase {
    
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id) {
        Optional<CourseEntity> courseOptional = this.courseRepository.findById(id);

        if (courseOptional.isPresent()) {
            return courseOptional.get();
        } else {
            throw new CourseNotFoundException();
        }
    }
}
