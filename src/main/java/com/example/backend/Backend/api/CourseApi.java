package com.example.backend.Backend.api;

import com.example.backend.Backend.business.CourseBusiness;
import com.example.backend.Backend.entity.Course;
import com.example.backend.Backend.exception.BaseException;
import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.model.ModelCourseRequest;
import com.example.backend.Backend.model.ModelRegsiterRequest;
import com.example.backend.Backend.model.testResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Log4j2

@RestController
@RequestMapping("/course")
public class CourseApi {
    private final CourseBusiness business;

    public CourseApi(CourseBusiness business) {
        this.business = business;
    }
    @PostMapping
    @RequestMapping(value = "/addCourse")
    public ResponseEntity<Course> createCourse(@RequestBody ModelCourseRequest request) throws BaseException {
        Course response = business.add(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @RequestMapping(value = "/getCourse")
    public List<Course> getCourse(){
        List<Course> response = business.getAllCourse();
        return response;
    }

}
