package com.lisa.lektion_5_uppgifter.controller;

import com.lisa.lektion_5_uppgifter.model.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/user")
public class CustomUserController {

    ArrayList<CustomUser> users = new ArrayList<CustomUser>();


    @GetMapping("/all")
    public ResponseEntity<?> getUsers(){

        return ResponseEntity.ok().build();
    }
}
