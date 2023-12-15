package com.example.entity.loginSignup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupForm {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String cpassword;

}
