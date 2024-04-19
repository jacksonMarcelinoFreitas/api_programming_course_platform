package br.com.jacksonfreitas.programming_courses.modules.course.useCases;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jacksonfreitas.programming_courses.exceptions.CourseNotFoundException;
import br.com.jacksonfreitas.programming_courses.modules.course.entities.CourseEntity;
import br.com.jacksonfreitas.programming_courses.exceptions.CourseUpdateNotAllowedException;
import br.com.jacksonfreitas.programming_courses.modules.course.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity, UUID id){
        Optional<CourseEntity> courseOptional = this.courseRepository.findById(id);

        if(courseOptional.isPresent()){

            CourseEntity course = courseOptional.get();
            
            if(courseEntity.getActive() != null){
                throw new CourseUpdateNotAllowedException();
            }else{
                // if(courseEntity.getActive() == null) {
                //     courseEntity.setActive(course.getActive());
                // }
                if(courseEntity.getName() != null){
                    course.setName(courseEntity.getName());
                }
                if(courseEntity.getCategory() != null) {
                    course.setCategory(courseEntity.getCategory());
                }
                course.setUpdated_at(LocalDateTime.now());

            }
            return this.courseRepository.save(course);


        }else{
            throw new CourseNotFoundException();
        }

    }
    
}
