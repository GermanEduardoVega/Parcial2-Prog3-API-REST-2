package com.example.Parcial1_ApiRest_VideosHasta16.services;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.BaseEntidad;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.BaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntidad, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository <E,ID> baseRepository;//llamamos una instancia de nuestro repositorio base lo hacemos protegido para que lo puedan utilizar las clases que heredan de BaseService

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {  //Constructor de esta clase
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();//obtiene de la BD todas las personas registradas
            return entities;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entityOpcional = baseRepository.findById(id);
            return entityOpcional.get();//este metodo va a obtener una entidad si es que la encuentra

        }catch (Exception e){   //de otra forma lanza una excepcion
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            //persona = personaRepository.save(persona); //se guarda la persona que obtengo de la BD
            entityUpdate = baseRepository.save(entity);   // guarda la nueva entidad actualizar
            return entityUpdate;

        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}

//Interfaz Generica BaseService
//implementacion Generica de este servicio (BaseService) que es abstracta (BaseServiceImpl) esta implementacion
// va a poder heredar cada uno de los servicios que hagamos y ya no vamos a tener que implementar esos metodos
// sino que los van a heredar de esta clase abstracta

//hacemos el Constructor
//llamamos una instancia de nuestro repositorio base lo hacemos protegido para que lo puedan utilizar las clases que heredan de BaseService
//Implementar los metoodos de nuestra interface BaseServiceImpl (los traemos de PersonaService)
//cambiamos el PersonaService para que consuma el BaseServiceImpl

//Traemos los metodos del personaService y los hacemos GENERICOS
//Tenemos el modelo actualizado para recibir los tipos que hemos asignado
//cambiar el persona service para que consuma este servicio

/**
 * Completando los metodos del servicio
 *  @Autowired
 *  private PersonaRepository personaRepository;
 *
 * BaseRepository<Persona, Long> en el PersonaService la BaseRepository que creamos en la implementacion de base service (BaseServiceImpl)va a tener todos los metodos del BaseRepository todos los metodos que hagamos
 * dentro de esta interface , pero si quisieramos acceder a los metodos que hagamos en el repositorio especifico de cada uno de estos modelos PersonaRepository, AutorRepository
 * vamos a tener que hacer una instancia de PersonaRepository de otra forma no podriamos acceder a los metodos por ejemplo si hacemos QUERYS en el PersonaRepository no vamos a poder acceder a esos
 * metodos desde el repositorio BaseEntidad
 * para eso hacemos el @Autowired de un repositorio de PersonaRepository en la clase PersonaService y de esta forma vamos
 * a poder acceder desde este repositorio a todos los metodos que este incluya
 *
 * Creamos el servicio para AutorService
 * */

//Tenemos
//Interfaz Generica BaseService
//Implementacion Abstracta de la interfaz BaseService "public abstract class BaseServiceImpl"
//y cada uno de los servicios: PersonaService, AutorService, para los modelos que precisemos
//estas 2 clases (BaseService y BaseServiceImpl)
// las vamos a poder reutilizar en todos los proyectos que necesitemos
// siempre y cuando sean estos los metodos que utilicemos

//     Metodo para listar todos los registros
//     public List<E> findAll() throws Exception;
//
//    //Metodo para buscar un registro por id que le pasemos
//    public E findById(ID id) throws Exception;
//
//    //Metodo para guardar una entidad recibida
//    public E save(E entity) throws Exception;
//
//    //Metodo para actualizar un registro y devolvemos ese registro actualizado
//    public E update(ID id, E entity) throws Exception;
//
//    //Metodo para eliminar un registro con un id pasado;
//    public boolean  delete(ID id) throws Exception;

//dentro de la interface BaseService van a estar todas las operaciones que sean comunes a todo el modelo