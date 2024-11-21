package com.example.Parcial1_ApiRest_VideosHasta16.services;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.BaseEntidad;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntidad,ID extends Serializable>{
//public interface BaseService<E>{  //1
//public interface BaseService<E extends BaseEntidad,ID extends Serializable>{ //9.2

    public List<E> findAll() throws Exception;              //Metodo para listar todos los registros
    public E findById(ID id) throws Exception;              //Metodo para buscar un registro por id que le pasemos
    //public E findById(Long id) throws Exception;          //1 Metodo para buscar un registro por id que le pasemos
    public E save(E entity) throws Exception;               //Metodo para guardar una entidad recibida
    public E update(ID id, E entity) throws Exception;      //Metodo para actualizar un registro y devolvemos ese registro actualizado
    //public E update(Long id, E entity) throws Exception;  //1 Metodo para actualizar un registro y devolvemos ese registro actualizado
    public boolean  delete(ID id) throws Exception;          //Metodo para eliminar un registro con un id pasado;
    //public boolean  delete(Long id) throws Exception;     //1 Metodo para eliminar un registro con un id pasado;

}


//Interfaz Generica BaseService
//implementacion Generica de este servicio (BaseService) que es abstracta (BaseServiceImpl) esta implementacion
// va a poder heredar cada uno de los servicios que hagamos y ya no vamos a tener que implementar esos metodos
// sino que los van a heredar de esta clase abstracta
