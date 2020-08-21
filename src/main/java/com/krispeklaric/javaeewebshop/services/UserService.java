/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services;

import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.models.UserRole;
import com.krispeklaric.javaeewebshop.repositories.UserRepository;
import com.krispeklaric.javaeewebshop.repositories.UserRoleRepository;
import com.krispeklaric.javaeewebshop.services.interfaces.IUserService;
import java.util.List;

/**
 *
 * @author Kris
 */
public class UserService implements IUserService {

    private UserRepository _userRepository;
    private UserRoleRepository _userRoleRepository;

    public UserService() {
        _userRepository = new UserRepository();
        _userRoleRepository = new UserRoleRepository();
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

    @Override
    public boolean checkIfEmailIsAvailable(String email) {
        return _userRepository.checkIfEmailIsAvailable(email);
    }

    @Override
    public UserRole getUserRole(User user) {
        return _userRoleRepository.get(user);
    }

    @Override
    public List<User> getAll() {
        return _userRepository.getAll();
    }

    @Override
    public User get(String username) {
        return _userRepository.getByUsername(username);
    }

}
