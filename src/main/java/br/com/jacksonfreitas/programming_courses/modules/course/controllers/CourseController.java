package br.com.jacksonfreitas.programming_courses.modules.course.controllers;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jacksonfreitas.programming_courses.modules.course.entities.CourseEntity;
import br.com.jacksonfreitas.programming_courses.modules.course.useCases.CreateCourseUseCase;
import br.com.jacksonfreitas.programming_courses.modules.course.useCases.ListAllCoursesUseCase;
import br.com.jacksonfreitas.programming_courses.modules.course.useCases.ShowCourseUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/courses")
public class CourseController {

    //Injeção de dependências
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListAllCoursesUseCase listAllCoursesUseCase;

    @Autowired
    private ShowCourseUseCase showCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var result = this.createCourseUseCase.execute(courseEntity);
             return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> index(CourseEntity courseEntity) {
        try {
            var result = this.listAllCoursesUseCase.execute();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(CourseEntity courseEntity, @PathVariable UUID id) {
        try {
            var result = this.showCourseUseCase.execute(id);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
}
