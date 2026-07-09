package com.castores.inventario.service;

import com.castores.inventario.model.Product;
import com.castores.inventario.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.castores.inventario.model.Movement;
import com.castores.inventario.repository.MovementRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MovementRepository movementRepository;

    public ProductService(
            ProductRepository productRepository,
            MovementRepository movementRepository
    ) {
        this.productRepository = productRepository;
        this.movementRepository = movementRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {

        product.setExistencia(0);

        product.setActivo(true);

        productRepository.save(product);

    }

    public void changeStatus(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return;
        }

        product.setActivo(!product.getActivo());

        productRepository.save(product);

    }

    public String addStock(Long id, Integer cantidad, String usuario) {

        if (cantidad == null || cantidad <= 0) {
            return "La cantidad debe ser mayor a 0.";
        }

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return "Producto no encontrado.";
        }

        product.setExistencia(product.getExistencia() + cantidad);
        productRepository.save(product);

        movementRepository.save(
                new Movement("Entrada", cantidad, usuario, product)
        );

        return null;
    }

    public String removeStock(Long id, Integer cantidad, String usuario) {

        if (cantidad == null || cantidad <= 0) {
            return "La cantidad debe ser mayor a 0.";
        }

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return "Producto no encontrado.";
        }

        if (!product.getActivo()) {
            return "No se puede sacar inventario de un producto inactivo.";
        }

        if (cantidad > product.getExistencia()) {
            return "No hay suficiente inventario.";
        }

        product.setExistencia(product.getExistencia() - cantidad);
        productRepository.save(product);

        movementRepository.save(
                new Movement("Salida", cantidad, usuario, product)
        );

        return null;
    }

    public List<Product> getActiveProducts() {
        return productRepository.findByActivoTrue();
    }

}