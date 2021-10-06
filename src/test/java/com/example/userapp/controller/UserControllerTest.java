//package com.example.userapp.controller;
//
//import com.example.userapp.domain.Address;
//import com.example.userapp.domain.ParentUser;
//import com.example.userapp.domain.User;
//import com.example.userapp.repository.UserRepository;
//import com.example.userapp.service.AddressServiceImpl;
//import com.example.userapp.service.ParentUserServiceImpl;
//import com.example.userapp.service.UserServiceImpl;
//import com.example.userapp.web.rest.UserController;
//import com.fasterxml.jackson.databind.json.JsonMapper;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.websocket.SendResult;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//    private static final String DEFAULT_FIRST_NAME = "FIRSTNAME";
//    private static final String DEFAULT_LAST_NAME = "LASTNAME";
//    private static final String DEFAULT_EMAIL = "default@yopmail.com";
//
//    private static final String DEFAULT_STATE = "STATE";
//    private static final String DEFAULT_CITY = "CITY";
//    private static final String DEFAULT_ZIP = "ZIP";
//    private static final String DEFAULT_STREET = "STREET";
//
//
//    @InjectMocks
//    UserController userController;
//    @Mock
//    UserServiceImpl userServiceImpl;
//    @Mock
//    AddressServiceImpl addressServiceImpl;
//    @Mock
//    ParentUserServiceImpl parentUserServiceImpl;
//    @Mock
//    UserRepository userRepository;
//    @Autowired
//    MockMvc mockMvc;
//
//
////    @Test
////    public void testListOfUsers() throws Exception {
////        ArrayList<User> users=new ArrayList<User>();
//////        User user=new User();
//////        Address address=new Address(1l,DEFAULT_STATE,DEFAULT_CITY,DEFAULT_ZIP,DEFAULT_STREET);
//////        ParentUser parentUser=new ParentUser(user,address);
////
////        users.add(new User(1L,DEFAULT_FIRST_NAME,DEFAULT_LAST_NAME,DEFAULT_EMAIL));
////        users.add(new User(2L,"USERTWO","USERTWOLAST","usertwo@yopmail.com"));
////        Mockito.when(userRepository.findAll()).thenReturn(users);
////        String url="/api/v1/users";
////        MvcResult mvcResult=mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
////        String actualJsonResponse=mvcResult.getResponse().getContentAsString();
////        System.out.println(actualJsonResponse);
////
////
//////        mockMvc.perform( MockMvcRequestBuilders
//////                            .get("/api/v1/users")
//////                            .accept(MediaType.APPLICATION_JSON))
//////                    .andDo(print())
//////                    .andExpect(status().isOk())
//////                    .andExpect(MockMvcResultMatchers.jsonPath("$.users").exists())
//////                    .andExpect(MockMvcResultMatchers.jsonPath("$.users[*].id").isNotEmpty());
////
////
////    }
//
////    @Test
////    public void getUsers() throws Exception {
////        String uri = "/users";
////        MvcResult mvcResult = mockMvc.perform(get(uri)
////                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
////
////        int status = mvcResult.getResponse().getStatus();
////        assertEquals(200, status);
////        String content = mvcResult.getResponse().getContentAsString();
////        User[] users = Mapper(content, User[].class);
////        assertTrue(users.length > 0);
////    }
//
//
//
//
//
//}
