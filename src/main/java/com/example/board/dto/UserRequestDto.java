package com.example.board.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.board.domain.User;
import com.example.board.enums.UserType;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class UserRequestDto {

    private String loginId;

    private String name;

    private String password;

    private String phoneNumber;

    private UserType userType;

    public User toEntity(UserRequestDto userRequestDto){
        return User.builder()
                .loginId(userRequestDto.getLoginId())
                .name(userRequestDto.getName())
                .password(userRequestDto.getPassword())
                .phoneNumber(userRequestDto.getPhoneNumber())
                .userType(userRequestDto.getUserType())
                .build();
    }
}
