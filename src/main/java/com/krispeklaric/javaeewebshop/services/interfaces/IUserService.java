/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services.interfaces;

import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.models.UserRole;
import java.util.List;

/**
 *
 * @author Kris
 */
public interface IUserService {

    User login(String username, String password);

    User register(User user);

    boolean checkIfUsernameIsAvailable(String username);

    boolean checkIfEmailIsAvailable(String email);

    UserRole getUserRole(User user);

    List<User> getAll();

    User get(String username);

}
