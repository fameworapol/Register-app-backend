package com.example.backend.Backend.business;

import com.example.backend.Backend.entity.User;
import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.mapper.UserMapper;
import com.example.backend.Backend.model.ModelLogin;
import com.example.backend.Backend.model.ModelRegsiterRequest;
import com.example.backend.Backend.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
@Log4j2
@Service
public class UserBusiness {
    private final UserService userService;
    private final UserMapper userMapper;
//    private final TokenService tokenService;

    public UserBusiness(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
//        this.tokenService = tokenService;
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
    public User login(ModelLogin request) throws UserException {
        if(request==null){
            throw UserException.requestNull();
        }

        Optional<User> opt = userService.findByEmail(request.getEmail());
        if(opt.isEmpty()){
            throw UserException.emailIsNotAlready();
        }
        User user = opt.get();

        if(!userService.matchPassword(request.getPassword(),user.getPassword())){
            throw UserException.passwordNotMatch();
        }
//        String token = tokenService.tokenize(user);
        return user;
    }
}
