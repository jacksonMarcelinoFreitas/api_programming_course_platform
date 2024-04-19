package br.com.jacksonfreitas.programming_courses.exceptions;

public class CourseUpdateNotAllowedException extends RuntimeException {
    public  CourseUpdateNotAllowedException(){
        super("Esta rota não atualiza active, tente novamente");
    }
}
