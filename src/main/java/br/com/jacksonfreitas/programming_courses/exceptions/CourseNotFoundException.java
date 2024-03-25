package br.com.jacksonfreitas.programming_courses.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public  CourseNotFoundException(){
        super("Curso não encontrado");
    }
}
