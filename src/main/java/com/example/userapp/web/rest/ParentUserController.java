package com.example.userapp.web.rest;

import com.example.userapp.domain.ParentUser;
import com.example.userapp.service.ParentUserService;
import com.example.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ParentUserController {
    @Autowired
    private ParentUserService parentUserService;

    //Fetch All Parent User
    @GetMapping("/parent-users")
    public List<ParentUser> getAllPArentUsers(){
        return parentUserService.getAllParentUsers();
    }
}

