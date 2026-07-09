package com.castores.inventario.service;

import com.castores.inventario.model.User;
import com.castores.inventario.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String correo, String password) {
        User user = userRepository.findByCorreo(correo);

        if (user == null) {
            return null;
        }

        if (!user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }
}