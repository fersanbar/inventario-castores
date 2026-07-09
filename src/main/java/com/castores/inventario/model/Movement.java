package com.castores.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private Integer cantidad;

    private String usuario;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product product;

    public Movement() {
    }

    public Movement(String tipo, Integer cantidad, String usuario, Product product) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.product = product;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Product getProduct() {
        return product;
    }
}