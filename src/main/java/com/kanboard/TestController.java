package com.kanboard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> Test() {
        String testing = "Testing API";
        return ResponseEntity.status(200).body(testing);
    }
}
