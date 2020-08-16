/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services;

import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.repositories.UserRepository;
import com.krispeklaric.javaeewebshop.services.interfaces.IUserService;

/**
 *
 * @author Kris
 */
public class UserService implements IUserService {

    private UserRepository _userRepository;

    public UserService() {
        _userRepository = new UserRepository();
    }

    @Override
    public User login(String username, String password) {

        return _userRepository.login(username, password);
    }

    @Override
    public User register(User user) {

        return _userRepository.register(user);

    }

    @Override
    public boolean checkIfUsernameIsAvailable(String username) {
        return _userRepository.checkIfUsernameIsAvailable(username);
    }

}
