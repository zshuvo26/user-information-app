package com.example.userapp.service;

import com.example.userapp.UserappApplication;
import com.example.userapp.domain.ParentUser;
import com.example.userapp.domain.User;
import com.example.userapp.repository.ChildUserRepository;
import com.example.userapp.repository.ParentUserRepository;
import com.example.userapp.repository.UserRepository;
import com.example.userapp.service.dto.*;
import com.example.userapp.web.rest.errors.InvalidValueException;
import com.example.userapp.web.rest.errors.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UserappApplication.class)
class UserServiceTest {
    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String DEFAULT_EMAIL = "default.email@mail.com";

    @Autowired
    private UserService userService;

    @Autowired
    private RequestPayloadService requestPayloadService;

    @Autowired
    private ParentUserRepository parentUserRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChildUserRepository childUserRepository;

    @BeforeEach
    void setUp() {
        childUserRepository.deleteAll();
        parentUserRepository.deleteAll();
        userRepository.deleteAll();

    }

    @Test
    @DisplayName("Create Parent Type User")
    void createParentUser() throws InvalidValueException {
        final RequestPayload payload = payloadForParent();

        Optional<? extends BaseDTO> baseDTO = requestPayloadService.create(payload);
        assertTrue(baseDTO.isPresent());
        assertTrue(baseDTO.get() instanceof ParentUserDTO);
        assertNotNull(((ParentUserDTO) baseDTO.get()).getUser());
    }

    @Test
    @DisplayName("Update Parent Type User")
    void updateParentUser() throws InvalidValueException {
        final RequestPayload payload = payloadForParent();
        try {
            payload.setUserId(getOrCreateParentId());
        } catch (InvalidValueException e) {
            e.printStackTrace();
        }
        Optional<? extends BaseDTO> baseDTO = requestPayloadService.update(payload);
        assertTrue(baseDTO.isPresent());
        assertTrue(baseDTO.get() instanceof ParentUserDTO);
        assertNotNull(((ParentUserDTO) baseDTO.get()).getUser());
    }

    @Test
    @DisplayName("Create Child Type User")
    void createChildUser() throws InvalidValueException {
        final RequestPayload payload = payloadForChild();

       // assertThrows(RuntimeException.class, () -> requestPayloadService.create(payload));

        payload.setParentId(getOrCreateParentId());

        Optional<? extends BaseDTO> baseDTO = requestPayloadService.create(payload);

        assertTrue(baseDTO.isPresent());
        assertTrue(baseDTO.get() instanceof ChildUserDTO);
        assertNotNull(((ChildUserDTO) baseDTO.get()).getUser());
    }




    private Long getOrCreateParentId() throws InvalidValueException {
        return parentUserRepository.findParentUserByUserEmail(DEFAULT_EMAIL)
                .map(ParentUser::getId)
                .orElseGet(() -> {
                    try {
                        return requestPayloadService.create(payloadForParent())
                                .map(BaseDTO::getId).orElse(null);
                    } catch (InvalidValueException e) {
                        return null;
                    }
                });
    }

    private RequestPayload payloadForChild() {
        RequestPayload payload = payloadForParent();
        payload.setChild(true);
        payload.setEmail("default.child@mail.com");
        return payload;
    }

    private RequestPayload payloadForParent() {
        RequestPayload payload = new RequestPayload();
        payload.setChild(false);
        payload.setFirstName(DEFAULT_FIRST_NAME);
        payload.setLastName(DEFAULT_LAST_NAME);
        payload.setEmail(DEFAULT_EMAIL);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("City A");
        addressDTO.setZip("zip");
        addressDTO.setState("state");
        addressDTO.setStreet("street A");

        payload.setAddress(addressDTO);
        return payload;
    }
//    @Test
//    @DisplayName("Get all users data")
//    public void test_getAllUser() {
//        User userOne=User.builder()
//                .id(1L)
//                .firstName(DEFAULT_FIRST_NAME)
//                .lastName(DEFAULT_LAST_NAME)
//                .build();
//        User userTwo=User.builder()
//                .id(1L)
//                .firstName(DEFAULT_FIRST_NAME)
//                .lastName(DEFAULT_LAST_NAME)
//                .build();
//        List<User> users = new ArrayList<>();
//        users.add(userOne);
//        users.add(userTwo);
//        when(userRepository.findAll()).thenReturn(users);
//        List<User> users1 = userRepository.findAll();
//        assertEquals(users, users1);
//    }*/


}