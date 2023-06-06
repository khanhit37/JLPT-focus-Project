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

public class RegisterRequest {
    private Long id;
    private String fullname;
    private String username;
    private String password;
    private String email;
    private Date birthday;
    private Role role;
    private String level;

}
