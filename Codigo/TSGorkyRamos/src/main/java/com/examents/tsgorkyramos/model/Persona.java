package com.examents.tsgorkyramos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @ManyToOne
    @JoinColumn(name = "id_vacaciones", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_VACACIONES"))
    private Vacaciones vacaciones;

    @Column(nullable = false, length = 50)
    private String nombres;
    @Column(nullable = false, length = 50)
    private String apellidosPaterno;
    @Column(nullable = false, length = 50)
    private String apellidosMaterno;
    @Column(nullable = false, length = 8)
    private String dni;
    @Column(nullable = false)
    private Integer edad;

}
