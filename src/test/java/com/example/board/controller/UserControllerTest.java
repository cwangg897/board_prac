package com.example.board.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.board.annotations.EnableMockMvc;
import com.example.board.dto.UserRequestDto;
import com.example.board.enums.UserType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@EnableMockMvc
@Transactional
class UserControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    void createUser() throws Exception{
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .loginId("user1")
                .name("이름1")
                .password("1234")
                .phoneNumber("010-1111-1111")
                .userType(UserType.USER)
                .build();

        String json = objectMapper.writeValueAsString(userRequestDto);
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }
}