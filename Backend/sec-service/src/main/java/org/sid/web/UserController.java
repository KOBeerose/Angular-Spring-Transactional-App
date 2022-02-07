package org.sid.web;

import lombok.Data;
import org.sid.entities.AppUser;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;


    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm){
        System.out.println("********************************"+userForm.getUsername()+" "+userForm.getAddress()+" "+userForm.getPassword());
        return  accountService.saveUser(userForm);
    }
    @GetMapping("/login")
    public String register(){
        System.out.println("wal l9laaaawiiiiiiiii");
        return "zebii";
    }
    @PostMapping("/loggin")
    public AppUser register(@RequestBody User user){
        System.out.println("********************************"+user.getUsername()+" "+user.getPassword());
        return  accountService.checkUser(user);
    }
    @PostMapping("/active")
    public AppUser active(@RequestBody User user){
        System.out.println("********************************"+user.getUsername()+" "+user.getPassword());
        String username = user.getUsername();
        return  accountService.loadUserByUsername(username);
    }

    @PostMapping("/actived")
    public AppUser actived(@RequestBody User user){
        System.out.println("********************************"+user.getUsername());
        return  accountService.activateAccount(user);
    }



}

