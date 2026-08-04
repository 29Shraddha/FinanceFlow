package com.financeflow.controller;

import com.financeflow.dto.UserRequestDTO;
import com.financeflow.dto.UserResponseDTO;
import com.financeflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO saveUser(@Valid @RequestBody UserRequestDTO request) {
        return userService.saveUser(request);
    }
}
