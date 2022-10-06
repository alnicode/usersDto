package com.example.demo.controller;

import com.example.demo.dto.UserReq;
import com.example.demo.dto.UserRes;
import com.example.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final IUserService service;

    @PostMapping
    public ResponseEntity<UserRes> register(@RequestBody UserReq request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<UserRes>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRes> get(@PathVariable("id") long id) {
        return ResponseEntity.of(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRes> update(@PathVariable("id") long id, @RequestBody UserReq request) {
        return ResponseEntity.of(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserRes> delete(@PathVariable("id") long id) {
        return service.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
