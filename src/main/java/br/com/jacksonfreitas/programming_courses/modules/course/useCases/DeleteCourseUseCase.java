package br.com.jacksonfreitas.programming_courses.modules.course.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jacksonfreitas.programming_courses.exceptions.CourseNotFoundException;
import br.com.jacksonfreitas.programming_courses.modules.course.entities.CourseEntity;
import br.com.jacksonfreitas.programming_courses.modules.course.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id){
        Optional<CourseEntity> courseOptional = this.courseRepository.findById(id);

        if (courseOptional.isPresent()) {
            this.courseRepository.deleteById(id);
        }else{
            throw new CourseNotFoundException();
        }
    }
    
}
