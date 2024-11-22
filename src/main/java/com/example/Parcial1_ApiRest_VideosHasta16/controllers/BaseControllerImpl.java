package com.example.Parcial1_ApiRest_VideosHasta16.controllers;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.BaseEntidad;
import com.example.Parcial1_ApiRest_VideosHasta16.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends BaseEntidad, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {
//public abstract class BaseControllerImpl<E extends BaseEntidad, ID extends Serializable> implements BaseController<E, ID> {

    @Autowired
    protected S servicio;

}
