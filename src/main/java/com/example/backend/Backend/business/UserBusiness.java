package com.example.backend.Backend.business;

import com.example.backend.Backend.exception.UserException;
import com.example.backend.Backend.model.ModelRegsiterRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserBusiness {
    public String register(ModelRegsiterRequest request) throws UserException {
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

        return "";
    }
}
