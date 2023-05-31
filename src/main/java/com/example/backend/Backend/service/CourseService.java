package com.example.backend.Backend.service;

import com.example.backend.Backend.entity.Course;
import com.example.backend.Backend.exception.BaseException;
import com.example.backend.Backend.exception.CourseException;
import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseService {
    private final CourseRepository courseRepository; //Inject course Repository
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(String course_id, String course_name, Integer open) throws BaseException {
        Course entity = new Course();
        if(Objects.isNull(course_id)){
            throw CourseException.courseidNull();
        }
        if(Objects.isNull(course_name)){
            throw CourseException.courseNameNull();
        }
        if(Objects.isNull(open)){
            throw CourseException.openNull();
        }

        entity.setCourse_name(course_name);
        entity.setCourse_id(course_id);
        entity.setOpen(open);

        return courseRepository.save(entity);

    }

    public List<Course> getAllCourse(){
      return (List<Course>) courseRepository.findAll();
    };
}
