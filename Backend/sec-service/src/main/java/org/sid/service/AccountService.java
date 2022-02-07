package org.sid.service;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.web.User;
import org.sid.web.UserForm;

public interface AccountService {
    public AppUser saveUser(UserForm userForm);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(AppUser appUser,String rolename);

    public AppUser activateAccount(User user);

    public AppUser checkUser(User user);
}
