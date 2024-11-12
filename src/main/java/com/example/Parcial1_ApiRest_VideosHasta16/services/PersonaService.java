package com.example.Parcial1_ApiRest_VideosHasta16.services;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Persona;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonaService implements BaseService<Persona>{

    //@Autowired
    private PersonaRepository personaRepository; //creamos el objeto que se va a comunicar con la bd
                                                //Declaramos el personaRepository para la inyeccion de dependencias a travez del constructor (o con autowired)

    //Constructor que reemplaza el Autowired
    public PersonaService (PersonaRepository personaRepository){// Este constructor no lo llamamos desde ningun lado spring se va a  encargar de obtener las dependencias que necesita el servicio
        this.personaRepository = personaRepository;

    }



    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> entities = personaRepository.findAll();//obtiene de la BD todas las personas registradas
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> entityOpcional = personaRepository.findById(id);
            return entityOpcional.get();//este metodo va a obtener una entidad si es que la encuentra

        }catch (Exception e){   //de otra forma lanza una excepcion
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepository.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(entity);
            return persona;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}




/**
 * Completando los metodos del servicio
 * */


