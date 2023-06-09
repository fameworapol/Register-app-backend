package com.example.backend.Backend.api;

import com.example.backend.Backend.business.UserBusiness;
import com.example.backend.Backend.entity.User;
import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.model.ModelLogin;
import com.example.backend.Backend.model.ModelLoginResponse;
import com.example.backend.Backend.model.ModelRegsiterRequest;
import com.example.backend.Backend.model.testResponse;
import com.example.backend.Backend.service.TokenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Log4j2

@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserBusiness business;
    private final TokenService tokenService;
    public UserApi(UserBusiness business, TokenService tokenService) {
        this.business = business;
        this.tokenService = tokenService;
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
    public ResponseEntity<User> register(@RequestBody ModelRegsiterRequest request) throws UserException {
        User response = business.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @RequestMapping(value = "/login")
    public ResponseEntity<ModelLoginResponse> login(@RequestBody ModelLogin request) throws UserException {
        User response = business.login(request);
        String token = tokenService.tokenize(response); //create token from user
        ModelLoginResponse res = new ModelLoginResponse();

        //Filter
        res.setToken(token);
        res.setStudent_id(response.getStudent_id());
        res.setStudent_name(response.getStudent_name());

        return ResponseEntity.ok(res);
    }





}
