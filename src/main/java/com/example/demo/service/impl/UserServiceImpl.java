package com.example.demo.service.impl;

import com.example.demo.dto.UserReq;
import com.example.demo.dto.UserRes;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserRes create(UserReq request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public List<UserRes> getAll() {
        return null;
    }

    @Override
    public Optional<UserRes> get(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<UserRes> update(long id, UserReq request) {
        final var toFind = repository.findById(id);

        if (toFind.isEmpty()) {
            return Optional.empty();
        }

        final var entity = mapper.toEntity(request);
        entity.setId(id);
        entity.setRegisteredAt(toFind.get().getRegisteredAt());

        return Optional.of(mapper.toResponse(repository.save(entity)));
    }

    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
