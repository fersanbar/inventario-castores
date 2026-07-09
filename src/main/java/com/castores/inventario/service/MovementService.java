package com.castores.inventario.service;

import com.castores.inventario.model.Movement;
import com.castores.inventario.repository.MovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void saveMovement(Movement movement) {
        movementRepository.save(movement);
    }

    public List<Movement> getMovements(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            return movementRepository.findAll();
        }

        return movementRepository.findByTipo(tipo);
    }
}