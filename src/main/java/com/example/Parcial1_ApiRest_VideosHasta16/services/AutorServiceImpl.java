package com.example.Parcial1_ApiRest_VideosHasta16.services;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Autor;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.AutorRepository;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements AutorService {
//public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> {
//public class AutorService extends BaseServiceImpl<Autor,Long> {

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {   //Constructor
        super(baseRepository);
    }



}
