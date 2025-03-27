package com.example.api.controller;

import com.example.api.model.dto.AuthRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Funcionando!");
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String authUser(@RequestBody AuthRequestDto body){
        return "";
    }
}
