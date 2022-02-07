package org.sid.web;

import lombok.Data;

@Data
public class UserForm{
    private String username;
    private String address;
    private String password;
    private String confirmedPassword;
}