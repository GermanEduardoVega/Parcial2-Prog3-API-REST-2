package com.example.Parcial1_ApiRest_VideosHasta16.controllers;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Localidad;
import com.example.Parcial1_ApiRest_VideosHasta16.services.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {
}
