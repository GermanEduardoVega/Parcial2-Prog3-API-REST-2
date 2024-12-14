package com.example.Parcial1_ApiRest_VideosHasta16.controllers;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.BaseEntidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController <E extends BaseEntidad,ID extends Serializable>{    //Operaciones basicas que realiza nuestro controller
//public interface BaseController <E extends BaseEntidad, ID extends Serializable>{
//public interface BaseController <E, ID >{
    //METODOS
    //Clases parametrizada
    public ResponseEntity<?>getAll();
    public ResponseEntity<?>getOne(@PathVariable ID id);
    public ResponseEntity<?>save(@RequestBody E entity);
    public ResponseEntity<?>update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?>delete(@PathVariable ID id);
    
}
