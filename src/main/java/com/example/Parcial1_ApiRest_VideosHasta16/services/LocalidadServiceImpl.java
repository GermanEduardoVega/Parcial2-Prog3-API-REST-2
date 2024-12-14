package com.example.Parcial1_ApiRest_VideosHasta16.services;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Localidad;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService{
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) { // enviamos el repositorio para localidad
        super(baseRepository);
    }
}
