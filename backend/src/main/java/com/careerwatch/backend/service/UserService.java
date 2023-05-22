package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById (Long id);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser (Long id);
}
