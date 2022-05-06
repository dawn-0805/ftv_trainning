package com.ftvtraining.service.impl;

import com.ftvtraining.converter.UserConverter;
import com.ftvtraining.dto.UserDto;
import com.ftvtraining.enity.UserEntity;
import com.ftvtraining.repository.UserRepository;
import com.ftvtraining.service.IUserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserConverter converter;

    public static final int USERS_PER_PAGE = 5;

    @Override
    public List<UserDto> findByPage(Optional<Integer> pageNumber , Optional<String> sortBy) {
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),USERS_PER_PAGE,Sort.Direction.ASC,sortBy.orElse("userName"));
        Page<UserEntity> page = repository.findAll(pageable);
        List<UserDto> list = new ArrayList<>();
        page.get().forEach(user -> {
            UserDto userDto = converter.convertToDto(user);
            list.add(userDto);
        });
        return list;
    }


    @Override
    @Transactional
    public UserDto save(UserDto newUser) {
        return converter.convertToDto(repository.save(converter.convertToEntity(newUser)));
    }

    @Override
    @Transactional
    public UserDto update(Integer userId,UserDto updateUser) throws NotFoundException {
        UserEntity user = Optional.ofNullable(repository.findById(userId).get())
                .orElseThrow(() -> new NotFoundException("User not found !"));
        user.setUserName(updateUser.getUserName());
        user.setUserStatus(updateUser.getUserStatus());
        return converter.convertToDto(repository.save(user));
    }

    @Override
    public UserDto findById(Integer userId) throws NotFoundException {
        UserEntity user = Optional.ofNullable(repository.findById(userId).get())
                .orElseThrow(() -> new NotFoundException("User not found !"));
        return converter.convertToDto(user);
    }

    @Override
    public void deleteUser(Integer userId) throws NotFoundException {
        UserEntity user = Optional.ofNullable(repository.findById(userId).get())
                .orElseThrow(() -> new NotFoundException("User not found !"));
        user.setUserStatus("inactive");
        repository.save(user);
    }


}
