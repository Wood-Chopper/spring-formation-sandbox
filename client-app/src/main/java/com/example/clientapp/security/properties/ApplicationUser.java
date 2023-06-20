package com.example.clientapp.security.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ApplicationUser {
    private String username;
    private String password;
    private String[] authorities;
}
