package com.alura.foroapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    private Topico topico;

    public Respuesta() {}

    public Respuesta(String mensaje, Topico topico) {
        this.mensaje = mensaje;
        this.topico = topico;
    }

    // Getters, Setters y ToString
}
