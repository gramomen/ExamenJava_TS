package com.examents.tsgorkyramos.service.impl;

import com.examents.tsgorkyramos.model.Vacaciones;
import com.examents.tsgorkyramos.repo.IGenericRepo;
import com.examents.tsgorkyramos.repo.IVacacionesRepo;
import com.examents.tsgorkyramos.service.IVacacionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacacionesServiceImpl extends CRUDImpl<Vacaciones,Integer> implements IVacacionesService {
    private final IVacacionesRepo repo;

    @Override
    protected IGenericRepo<Vacaciones, Integer> getRepo() {
        return repo;
    }
}
