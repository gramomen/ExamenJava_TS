package com.examents.tsgorkyramos.dto;

import com.examents.tsgorkyramos.model.Vacaciones;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaDTO {

    @JsonBackReference
    private VacacionesDTO vacaciones;

    @Size(min = 1, max = 60)
    @NotNull
    private String nombresPersona;
    @NotNull
    private String apellidosPaterno;
    @NotNull
    private String apellidosMaterno;
    @NotNull
    private String dni;
    @NotNull
    private Integer edad;

}
