package com.sam.user.controller;

import com.sam.user.model.User;
import com.sam.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void findByStatus() throws Exception {
        when(userService.findByStatus("ACTIVE")).thenReturn(
                Collections.emptyList()
        );

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


        verify(userService).findByStatus("ACTIVE");
    }

    @Test
    void findById() throws Exception {

        User user = new User(1,"Sam","Seda",new Date(1990,03,17), "ACTIVE");

        when(userService.findById(1)).thenReturn(Optional.of(user));

        MvcResult mvcResult = mockMvc.perform(
                post("/api/user/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        verify(userService).findById(1);

    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}