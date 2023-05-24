package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.user.UpdateUserDto;
import com.careerwatch.backend.dto.user.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById (Long id);
    UserDto updateUser(Long id, UpdateUserDto userDto);
    void deleteUser (Long id);
}
