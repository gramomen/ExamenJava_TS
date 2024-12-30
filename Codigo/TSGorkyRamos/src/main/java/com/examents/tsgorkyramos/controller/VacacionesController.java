package com.examents.tsgorkyramos.controller;

import com.examents.tsgorkyramos.dto.GenericResponse;
import com.examents.tsgorkyramos.dto.VacacionesDTO;
import com.examents.tsgorkyramos.model.Vacaciones;
import com.examents.tsgorkyramos.service.IVacacionesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/vacaciones")
@RequiredArgsConstructor
public class VacacionesController {
    private final IVacacionesService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<VacacionesDTO>> getallMatriculas(){
        List<VacacionesDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<VacacionesDTO>> getMatriculaById(@PathVariable("id") int id){
        Vacaciones obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))) );
    }

    @PostMapping
    public ResponseEntity<Void>  save(@Valid @RequestBody VacacionesDTO dto){
        Vacaciones obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVacaciones()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<VacacionesDTO>> update(@PathVariable("id") Integer id,@Valid @RequestBody VacacionesDTO dto){
        Vacaciones obj = service.update(id, convertToEntity(dto));
        return  ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDto(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private VacacionesDTO convertToDto(Vacaciones obj) {
        return modelMapper.map(obj, VacacionesDTO.class);
    }

    private Vacaciones convertToEntity(VacacionesDTO dto) {
        return modelMapper.map(dto, Vacaciones.class);
    }
}
