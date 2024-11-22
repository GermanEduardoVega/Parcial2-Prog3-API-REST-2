package com.example.Parcial1_ApiRest_VideosHasta16.controllers;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Persona;
import com.example.Parcial1_ApiRest_VideosHasta16.services.PersonaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
// Define esta clase como un controlador REST, un bean que maneja solicitudes HTTP
@CrossOrigin(origins = "*")
// Permite el acceso desde distintos orígenes o clientes a los datos de la API
@RequestMapping("api/v1/personas")              // URI base para acceder a los recursos de Persona
public class PersonaController {
    //@Autowired
    private PersonaServiceImpl personaServiceImpl;       // Inyección de dependencia para el servicio de PersonaServiceImpl
    //private PersonaService personaService;            // Inyección de dependencia para el servicio de PersonaService

    // Constructor para inyectar PersonaService, reemplazando la anotación @Autowired
    public PersonaController (PersonaServiceImpl personaServiceImpl) {
        this.personaServiceImpl = personaServiceImpl;
    }

}


/**
 * Clase de controlador REST para manejar las solicitudes HTTP de la aplicación web.
 * <p>
 * Uso de ResponseEntity:
 * ResponseEntity<?> permite manejar las respuestas de una manera estructurada, incluyendo:
 * - Status HTTP: define el estado de la respuesta (éxito, error, etc.) mediante códigos de estado HTTP.
 * - Body: permite enviar los datos en formato JSON como cuerpo de la respuesta.
 * <p>
 * Tipos de solicitudes (Request):
 * <p>
 * OBTENER TODOS LOS REGISTROS
 *
 * @GetMapping("") // Define una solicitud de tipo GET para obtener todos los registros usando el método getAll().
 * Método:
 * public ResponseEntity<?> getAll()
 * <p>
 * OBTENER UN REGISTRO POR ID
 * @GetMapping("/{id}") // Define una solicitud de tipo GET para obtener un registro específico mediante el ID en la URI.
 * Métodos:
 * public ResponseEntity<?> getOne(Long id)
 * public ResponseEntity<?> getOne(@PathVariable Long id)  // El parámetro id se obtiene de la URL para acceder al recurso.
 * <p>
 * GUARDAR UN REGISTRO
 * @PostMapping("") // Define una solicitud de tipo POST para guardar un nuevo registro.
 * Métodos:
 * public ResponseEntity<?> save(Persona entity)
 * public ResponseEntity<?> save(@RequestBody Persona entity)  // La entidad Persona se envía en el cuerpo de la solicitud POST.
 * <p>
 * ACTUALIZAR UN REGISTRO
 * @PutMapping("/{id}") // Define una solicitud de tipo PUT para actualizar un registro existente mediante el ID.
 * Métodos:
 * public ResponseEntity<?> update(Long id, Persona entity)
 * public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity)  // ID en la URL, entidad en el cuerpo de la solicitud.
 * <p>
 * BORRAR UN REGISTRO
 * @DeleteMapping("/{id}") // Define una solicitud de tipo DELETE para borrar un registro específico mediante el ID en la URI.
 * Métodos:
 * public ResponseEntity<?> delete(Long id)
 * public ResponseEntity<?> delete(@PathVariable Long id)  // El ID del registro se obtiene de la URL para acceder al recurso.
 */