package com.castores.inventario.repository;

import com.castores.inventario.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByCorreo(String correo);

}