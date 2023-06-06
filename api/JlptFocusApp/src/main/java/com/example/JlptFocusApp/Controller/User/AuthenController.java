package com.example.JlptFocusApp.Controller.User;

import com.example.JlptFocusApp.Authenticate.AuthenticationRequest;
import com.example.JlptFocusApp.Authenticate.AuthenticationResponse;
import com.example.JlptFocusApp.Authenticate.RegisterRequest;
import com.example.JlptFocusApp.Entity.User.Role;
import com.example.JlptFocusApp.Entity.User.User;
import com.example.JlptFocusApp.Service.User.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/auth")
public class AuthenController {
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {

        Optional<User> existingUser = authenticationService.findByUsername(registerRequest.getUsername());

        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email đã được sử dụng");

        }
        return ResponseEntity.ok(authenticationService.register(registerRequest));


    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.login(authenticationRequest));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        User existingUser = authenticationService.findById(id);



        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        existingUser.setFullname(user.getFullname() != null ? user.getFullname() : existingUser.getFullname());
        existingUser.setEmail(user.getEmail()!= null ? user.getEmail() : existingUser.getEmail());
        existingUser.setLevel(user.getLevel() != null ? user.getLevel() : existingUser.getLevel());
        existingUser.setBirthday(user.getBirthday() != null ? user.getBirthday() : existingUser.getBirthday());
        if (user.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        existingUser.setRole(Role.USER);

        User updateUser = authenticationService.updateUser(existingUser);
        return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        authenticationService.deleteById(id);
    }

}




