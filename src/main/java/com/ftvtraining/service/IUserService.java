package com.ftvtraining.service;


import com.ftvtraining.dto.UserDto;
import javassist.NotFoundException;


import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserDto> findByPage(Optional<Integer> pageNumber, Optional<String> sortBy);
    UserDto save(UserDto newUser);
    UserDto update(Integer userId, UserDto updateUser) throws NotFoundException;
    UserDto findById(Integer userId) throws NotFoundException;
    void deleteUser(Integer userId) throws NotFoundException;


}
