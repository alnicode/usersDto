package com.example.demo.service;

import com.example.demo.dto.UserReq;
import com.example.demo.dto.UserRes;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserRes create(UserReq request);
    List<UserRes> getAll();
    Optional<UserRes> get(long id);
    Optional<UserRes> update(long id, UserReq request);
    boolean delete(long id);
}
