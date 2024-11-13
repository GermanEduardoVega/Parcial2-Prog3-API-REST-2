package com.example.Parcial1_ApiRest_VideosHasta16.services;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.BaseEntidad;
import com.example.Parcial1_ApiRest_VideosHasta16.entities.Persona;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.BaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntidad, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository <E,ID> baseRepository;//llamamos una instancia de nuestro repositorio base lo hacemos protegido para que lo puedan utilizar las clases que heredan de BaseService

    //Constructor
    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }


    //Traemos los metodos del personaService y los hacemos GENERICOS

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
            //persona = personaRepository.save(persona); //se guarda la persona que obtengo de la BD
            persona = personaRepository.save(entity);   // guarda la nueva entidad actualizar
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
