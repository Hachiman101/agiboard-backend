package com.kanboard;

import com.kanboard.entity.User;
import com.kanboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<String> Test() {
        String testing = "Testing API";
        return ResponseEntity.status(200).body(testing);
    }

    @GetMapping("/create")
    public ResponseEntity<User> create() {
        User user = new User();
        user.setName("name");
        user.setUsername("username");
        user.setPassword("password");
        user.setBoards(new ArrayList<>());

        userRepository.save(user);
        User userReturn = userRepository.findByUsername(user.getUsername());
        return ResponseEntity.status(200).body(userReturn);
    }

    @GetMapping("/get")
    public ResponseEntity<User> get() {
        User userReturn = userRepository.findByUsername("username");
        return ResponseEntity.status(200).body(userReturn);
    }
}
