package com.fomov.road_rules_api.controller;

import com.fomov.road_rules_api.dto.RegistrationRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;
import com.fomov.road_rules_api.facade.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserFacade userFacade;

    public AuthController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(
            @RequestBody RegistrationRequestDto registrationRequestDto) {
        UserResponseDto createdUser = userFacade.registerUser(registrationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> currentUser(Authentication authentication) {
        UserResponseDto user = (UserResponseDto) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }
}
