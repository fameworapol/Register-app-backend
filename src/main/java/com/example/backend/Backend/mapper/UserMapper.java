package com.example.backend.Backend.mapper;

import com.example.backend.Backend.entity.User;
import com.example.backend.Backend.model.ModelLoginResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ModelLoginResponse toLoginResponse(User user);
}
