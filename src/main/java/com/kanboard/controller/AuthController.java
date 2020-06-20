package com.kanboard.controller;

import com.kanboard.dto.AuthTokenDTO;
import com.kanboard.dto.UserDTO;
import com.kanboard.entity.User;
import com.kanboard.service.UserServiceInterface;
import com.kanboard.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/token")
public class AuthController {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserServiceInterface userServiceInterface;

    @Autowired
    public AuthController(JwtTokenUtil jwtTokenUtil, AuthenticationManager authenticationManager,
                          UserServiceInterface userServiceInterface) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.userServiceInterface = userServiceInterface;
    }

    @PostMapping(value = "/generate-token")
    public ResponseEntity<AuthTokenDTO> generateToken(@RequestBody UserDTO loginUser) throws AuthenticationException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userServiceInterface.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.status(200).body(new AuthTokenDTO(token, user.getUsername()));
    }
}
