package com.example.backend.Backend.exception;

public class UserException extends BaseException{
    public UserException(String code) {
        super("user."+code);
    }

    public static UserException requestNull(){return new UserException("register.request.null");}
    public static UserException emailNull(){return new UserException("register.email.null");}
    public static UserException requestStdIdNull(){return new UserException("register.stdid.null");}
    public static UserException passwordNull(){return new UserException("register.password.null");}
    public static UserException nameNull(){return new UserException("register.name.null");}
    public static UserException emailAlreadyExist(){return new UserException("email.already.exist");}
    public static UserException emailIsNotAlready(){return new UserException("email.not.already");}
    public static UserException passwordNotMatch(){return new UserException("password.not.match");}
}
