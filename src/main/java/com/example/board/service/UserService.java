package com.example.board.service;

import com.example.board.domain.User;
import com.example.board.dto.UserRequestDto;
import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserRequestDto userDto) {
        User user = userDto.toEntity(userDto);
        userRepository.save(user);
    }
}
