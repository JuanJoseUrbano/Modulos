package com.example.ejonespringboot.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String name;
    private String marca;
    private float costo;
    private int cant;

    public Producto(long id, String name, String marca, float costo, int cant) {
        this.id = id;
        this.name = name;
        this.marca = marca;
        this.costo = costo;
        this.cant = cant;
    }
    public Producto(){};
}
