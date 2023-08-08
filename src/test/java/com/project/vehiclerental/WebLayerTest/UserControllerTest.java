package com.project.vehiclerental.WebLayerTest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.vehiclerental.controller.UserController;
import com.project.vehiclerental.dto.UserDto;
import com.project.vehiclerental.enums.Gender;
import com.project.vehiclerental.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testGetUsers() throws Exception {
        List<UserDto> userDtos = Arrays.asList(new UserDto(), new UserDto());
        given(userService.getAllUser()).willReturn(userDtos);
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDtos)));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testFindUserByID() throws Exception {
        UserDto userDto = new UserDto();
        given(userService.findUser(1L)).willReturn(userDto);
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDto)));
    }

    @Test
    @WithMockUser(roles = "IS_AUTHENTICATED_FULLY")
    public void testAddUser() throws Exception {
        UserDto userDto = new UserDto();

        //set some values for the userDto
        userDto.setId(1L);
        userDto.setUsername("test");
        userDto.setName("tester");
        userDto.setGender(Gender.MALE);
        userDto.setEmail("something@example.com");
        userDto.setPassword("password");

        given(userService.saveUser(userDto)).willReturn(userDto);
        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDto)));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testUpdateUser() throws Exception {
        UserDto userDto = new UserDto();

        given(userService.updateUser(1L, userDto)).willReturn(userDto);
        mockMvc.perform(put("/api/v1/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDto)));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testPatchUser() throws Exception {
        UserDto userDto = new UserDto();
        given(userService.updateUser(1L, userDto)).willReturn(userDto);
        mockMvc.perform(patch("/api/v1/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(Collections.singletonMap("userDto", userDto))))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDto)));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testDeleteVehicle() throws Exception {
        UserDto userDto = new UserDto();
        given(userService.deleteUser(1L)).willReturn(userDto);
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().isNoContent())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userDto)));
    }
}