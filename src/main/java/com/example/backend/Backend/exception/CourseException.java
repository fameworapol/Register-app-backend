package com.example.backend.Backend.exception;

public class CourseException extends BaseException{
    public CourseException(String code) {
        super("course."+code);
    }

    public static CourseException requestNull(){return new CourseException("course.request.null");}

    public static CourseException courseidNull(){return new CourseException("course.id.null");}

    public static CourseException courseNameNull(){return new CourseException("course.name.null");}

    public static CourseException openNull(){return new CourseException("course.open.null");}
}
