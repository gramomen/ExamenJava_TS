package com.examents.tsgorkyramos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vacaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVacaciones;
    @Column(nullable = false, length = 100)
    private String descripcion;
    @Column(nullable = false)
    private LocalDateTime fechaInicio;
    @Column(nullable = false)
    private LocalDateTime fechaFin;
    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "vacaciones", cascade = CascadeType.ALL) //, fetch = FetchType.EAGER)
    private List<Persona> detallePersona;
}
