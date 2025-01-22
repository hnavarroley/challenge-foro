package com.alura.foroapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico() {}

    public Topico(String titulo, String mensaje) {
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    // Getters, Setters y ToString
}
