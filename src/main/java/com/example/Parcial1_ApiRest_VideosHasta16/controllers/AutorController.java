package com.example.Parcial1_ApiRest_VideosHasta16.controllers;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Autor;
import com.example.Parcial1_ApiRest_VideosHasta16.services.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{
}
