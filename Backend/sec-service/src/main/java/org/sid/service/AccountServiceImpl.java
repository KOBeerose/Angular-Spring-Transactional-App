package org.sid.service;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.AppUserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.web.User;
import org.sid.web.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository ;

    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //se constructor est equivalence a Autowired
    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(UserForm userForm) {
        AppUser user = appUserRepository.findByUsername(userForm.getUsername());
        if (user!=null) throw new RuntimeException("User already exists");
        if (!userForm.getPassword().equals(userForm.getConfirmedPassword())) throw new RuntimeException("Please confirm your password");
        AppUser appUser = new AppUser();
        appUser.setUsername(userForm.getUsername());
        appUser.setActived(false);
        appUser.setAddress(userForm.getAddress());
        appUser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        System.out.println("**"+appUser.getUsername()+"**"+appUser.getAddress()+" "+ appUser.getPassword());
        //appUserRepository.save(appUser);
        addRoleToUser(appUser,"USER");


        return appUser  ;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }


    @Override
    public void addRoleToUser(AppUser appUser, String rolename) {
       // AppUser appUser = appUserRepository.findByUsername(userForm.getUsername());
        AppRole appRole = appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
        appUserRepository.save(appUser);
        appRoleRepository.save(appRole);
    }

    @Override
    public AppUser activateAccount(User user) {
        AppUser appUser = appUserRepository.findByUsername(user.getUsername());
        appUser.setActived(true);
        return appUser;
    }
    @Override
    public AppUser checkUser(User user) {
        AppUser appUser = appUserRepository.findByUsername(user.getUsername());
        if (appUser==null) throw new RuntimeException("User Does not exists");
        if (! bCryptPasswordEncoder.matches(user.getPassword(), appUser.getPassword())) throw new RuntimeException("Password is Incorrect!");
        return appUser;
    }



    }

