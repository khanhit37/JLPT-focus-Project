package com.example.JlptFocusApp.Service.User;

import com.example.JlptFocusApp.Authenticate.AuthenticationRequest;
import com.example.JlptFocusApp.Authenticate.AuthenticationResponse;
import com.example.JlptFocusApp.Authenticate.RegisterRequest;
import com.example.JlptFocusApp.Entity.User.User;
import com.example.JlptFocusApp.Repository.User.AuthenticateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    AuthenticateRepository authenticateRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    public Optional<User> findByUsername(String username) {
        return authenticateRepository.findByUsername(username);
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {

        var user = User.builder()
                .username(registerRequest.getUsername())
                .level(registerRequest.getLevel())
                .fullname(registerRequest.getFullname())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .birthday(registerRequest.getBirthday())
                .role(registerRequest.getRole())
                .build();

        authenticateRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(registerRequest.getUsername())
                .level(registerRequest.getLevel())
                .fullname(registerRequest.getFullname())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .birthday(registerRequest.getBirthday())
                .role(registerRequest.getRole())
                .build();
    }


    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        var user =
                authenticateRepository.findByUsername(
                        authenticationRequest.getUsername()
                ).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(jwtToken)
                .level(user.getLevel())
                .fullname(user.getFullname())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .role(user.getRole()).
                build();
    }


    public User findById(Long id) {
        return authenticateRepository.findById(id).orElse(null);
    }

    public void save(User updatingUser) {
         authenticateRepository.save(updatingUser);
    }

    public User updateUser(User existingUser) {
        return authenticateRepository.save(existingUser);
    }

    public void deleteById(Long id) {
        authenticateRepository.deleteById(id);
    }
}
