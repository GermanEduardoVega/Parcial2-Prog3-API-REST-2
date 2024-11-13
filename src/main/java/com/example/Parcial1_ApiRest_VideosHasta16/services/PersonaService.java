package com.example.Parcial1_ApiRest_VideosHasta16.services;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Persona;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.BaseRepository;
import com.example.Parcial1_ApiRest_VideosHasta16.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonaService extends BaseServiceImpl<Persona,Long>{
//public class PersonaService implements BaseService<Persona>{

    @Autowired
    private PersonaRepository personaRepository; //creamos el objeto que se va a comunicar con la bd
                                                //Declaramos el personaRepository para la inyeccion de dependencias a travez del constructor

    public PersonaService (BaseRepository<Persona, Long> baseRepository){// Este constructor no lo llamamos desde ningun lado spring se va a  encargar de obtener las dependencias que necesita el servicio
        super(baseRepository);

    }
}




/**
 * Completando los metodos del servicio
 *@Autowired
 *     private PersonaRepository personaRepository;
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


