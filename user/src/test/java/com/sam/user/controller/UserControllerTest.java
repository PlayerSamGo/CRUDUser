package com.sam.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.user.model.User;
import com.sam.user.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void findByStatusUser200Status() throws Exception {
        when(userService.findByStatus("ACTIVE")).thenReturn(
                Collections.emptyList()
        );

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


        verify(userService).findByStatus("ACTIVE");
    }

    @Test
    void findByIdUser200Status() throws Exception {

        User user = new User(1,"Sam","Seda",new Date(1990,03,17), "ACTIVE");
        userService.create(user);

        when(userService.findById(1)).thenReturn(Optional.of(user));

        mockMvc.perform(
                post("/api/user/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        verify(userService).findById(1);

    }

    @Test
    void createUser201Status() throws Exception {

        String json= "{" +
                "\"firstName\": \"Samuel Ivan\", " +
                "\"lastName\": \"Seda Legaria\", " +
                "\"dateOfBirth\": \"1990-03-17T18:25:43.511Z\"" +
                "}";

        mockMvc.perform(
                post("/api/user")
                .contentType("application/json")
                .content(json))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    void updateUser200Status() throws Exception {
        User user = new User(1,"Sam","Seda",new Date(1990,03,17), "ACTIVE");
        userService.create(user);

        when(userService.findById(1)).thenReturn(Optional.of(user));

        String json= "{" +
                "\"id\": \"1\", " +
                "\"firstName\": \"Samuel Ivan\", " +
                "\"lastName\": \"Seda Legaria\", " +
                "\"dateOfBirth\": \"1990-03-17T18:25:43.511Z\", " +
                "\"status\": \"INACTIVE\"" +
                "}";

        mockMvc.perform(
                put("/api/user")
                .contentType("application/json")
                .content(json))
                .andDo(print())
                .andExpect(status().isOk());

        verify(userService).findById(1);
    }

    @Test
    void deleteUser200Status() throws Exception {

        User user = new User(1,"Sam","Seda",new Date(1990,03,17), "ACTIVE");
        userService.create(user);

        when(userService.findById(1)).thenReturn(Optional.of(user));

        mockMvc.perform(
                delete("/api/user/1"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(userService).findById(1);
    }
}