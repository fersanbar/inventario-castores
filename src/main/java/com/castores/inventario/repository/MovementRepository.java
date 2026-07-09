package com.castores.inventario.repository;

import com.castores.inventario.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {

    List<Movement> findByTipo(String tipo);

}