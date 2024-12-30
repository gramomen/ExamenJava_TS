package com.examents.tsgorkyramos.dto;

import com.examents.tsgorkyramos.model.Persona;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VacacionesDTO {
    private Integer idVacaciones;
    @NotNull
    @Size(min = 5, max = 50)
    private String descripcion;
    @NotNull
    private LocalDateTime fechaInicio;
    @NotNull
    private LocalDateTime fechaFin;
    @NotNull
    private boolean estado;
    @NotNull
    @JsonManagedReference
    private List<PersonaDTO> detallePersona;
}
