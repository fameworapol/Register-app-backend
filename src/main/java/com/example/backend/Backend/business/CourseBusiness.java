package com.example.backend.Backend.business;

import com.example.backend.Backend.entity.Course;
import com.example.backend.Backend.exception.BaseException;
import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.model.ModelCourseRequest;
import com.example.backend.Backend.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseBusiness {
    public final CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public Course add(ModelCourseRequest request) throws BaseException {
        if(request==null){
            throw UserException.requestNull();
        }
        Course course = courseService.addCourse(request.getCourse_id(),request.getCourse_name(),request.getOpen());
        return course;
    }

    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }
}
