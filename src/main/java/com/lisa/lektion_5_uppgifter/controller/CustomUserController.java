package com.lisa.lektion_5_uppgifter.controller;

import com.lisa.lektion_5_uppgifter.model.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class CustomUserController {

    List<CustomUser> userList = new ArrayList<>(
            List.of(
                    new CustomUser(0, "Benny", "123", true),
                    new CustomUser(1, "Frida", "abc", true),
                    new CustomUser(2, "Anton", "456", true),
                    new CustomUser(3, "Arvid", "789", true),
                    new CustomUser(4, "Arvid", "def", false)
            )
    );


    @GetMapping("/all")
    public ResponseEntity<List<CustomUser>> getUsers(){

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomUser> getUserById(@PathVariable int id){

        return ResponseEntity.ok(userList.get(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CustomUser> deleteUserById(@RequestParam int id){

        if (id < 0 || id > userList.size()){
            return ResponseEntity.notFound().build();
        }

        CustomUser userToDelete = userList.get(id);

        if (!userToDelete.isEnabled()){
            return ResponseEntity.notFound().build();
        }

        userList.remove(id);
        return ResponseEntity.ok(userToDelete);
    }
}
