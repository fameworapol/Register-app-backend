package com.example.backend.Backend.business;

import com.example.backend.Backend.entity.User;
import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.model.ModelLogin;
import com.example.backend.Backend.model.ModelRegsiterRequest;
import com.example.backend.Backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserBusiness {
    private UserService userService;

    public UserBusiness(UserService userService) {
        this.userService = userService;
    }

    public User register(ModelRegsiterRequest request) throws UserException {
        if(request==null){
            throw UserException.requestNull();
        }
        if (Objects.isNull(request.getEmail())){
            throw UserException.emailNull();
        }
        if(Objects.isNull(request.getPassword())){
            throw UserException.passwordNull();
        }
        if(Objects.isNull(request.getStudent_id())){
            throw UserException.requestStdIdNull();
        }
        if(Objects.isNull(request.getStudent_name())){
            throw UserException.nameNull();
        }
        User user = userService.createUser(request.getStudent_name(),request.getStudent_id(),request.getEmail(),request.getPassword());
        return user;
    }
    public String login(ModelLogin request) throws UserException {
        if(request==null){
            throw UserException.requestNull();
        }

        return "";
    }
}
