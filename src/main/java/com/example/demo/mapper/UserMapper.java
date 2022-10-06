package com.example.demo.mapper;

import com.example.demo.dto.UserReq;
import com.example.demo.dto.UserRes;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRes toResponse(User entity);

    @Mapping(target = "registeredAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    User toEntity(UserReq request);

}
