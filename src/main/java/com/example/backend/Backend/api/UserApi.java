package com.example.backend.Backend.api;

import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.model.ModelRegsiterRequest;
import com.example.backend.Backend.model.testResponse;
import com.example.backend.Backend.business.UserBusiness;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Log4j2

@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserBusiness business;

    public UserApi(UserBusiness business) {
        this.business = business;
    }

    @GetMapping
    public testResponse test(){
        testResponse response = new testResponse();
        response.setName("fame");
        response.setAge(23);
        return response;
    }
    @PostMapping
    @RequestMapping(value = "/post")
    public ResponseEntity<String> testPost(@RequestBody testResponse request){
        log.info(request.getName());
        log.info(request.getAge());
        return ResponseEntity.ok("complete");
    }

    @PostMapping
    @RequestMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody ModelRegsiterRequest request) throws UserException {
        String response = business.register(request);
        return ResponseEntity.ok("complete");
    }





}
