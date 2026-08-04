package com.financeflow.controller;

import com.financeflow.dto.LoginRequestDTO;
import com.financeflow.dto.LoginResponseDTO;
import com.financeflow.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO request){

        return authService.login(request);

    }

}
