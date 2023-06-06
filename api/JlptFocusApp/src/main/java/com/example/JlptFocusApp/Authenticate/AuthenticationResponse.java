package com.example.JlptFocusApp.Authenticate;

import com.example.JlptFocusApp.Entity.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AuthenticationResponse {


        private Long id;
        private String username;
        private String fullname;
        private String password;
        private String email;
        private String token;
        private Role role;
        private Date birthday;
        private String level;

    }
