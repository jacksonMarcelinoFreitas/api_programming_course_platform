package br.com.jacksonfreitas.programming_courses.exceptions;

public class CourseFoundException extends RuntimeException {
    public CourseFoundException(){
        super("Curso já existe");
    }
    
}
