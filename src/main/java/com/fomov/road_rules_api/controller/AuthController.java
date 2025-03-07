package com.fomov.road_rules_api.controller;

import com.fomov.road_rules_api.dto.LoginRegistrationRequestDto;
import com.fomov.road_rules_api.dto.UserResponseDto;
import com.fomov.road_rules_api.facade.UserFacade;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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
            @RequestBody LoginRegistrationRequestDto loginRegistrationRequestDto) {
        UserResponseDto createdUser = userFacade.registerUser(loginRegistrationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRegistrationRequestDto loginRegistrationRequestDto, HttpServletRequest request) {
        try {
            userFacade.loginUser(loginRegistrationRequestDto, request);

            return ResponseEntity.ok("Успешный вход");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверное имя пользователя или пароль");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok(authentication.getPrincipal());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Пользователь не аутентифицирован");
    }
}
