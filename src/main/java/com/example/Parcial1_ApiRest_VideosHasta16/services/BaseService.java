package com.example.Parcial1_ApiRest_VideosHasta16.services;

import java.util.List;

public interface BaseService<E>{
    //Metodo para listar todos los registros
    public List<E> findAll() throws Exception;

    //Metodo para buscar un registro por id que le pasemos
    public E findById(Long id) throws Exception;

    //Metodo para guardar una entidad recibida
    public E save(E entity) throws Exception;

    //Metodo para actualizar un registro y devolvemos ese registro actualizado
    public E update(Long id, E entity) throws Exception;

    //Metodo para eliminar un registro con un id pasado;
    public boolean delete(Long id) throws Exception;



}
