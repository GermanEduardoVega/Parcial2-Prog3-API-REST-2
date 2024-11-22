package com.example.Parcial1_ApiRest_VideosHasta16.controllers;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.BaseEntidad;
import com.example.Parcial1_ApiRest_VideosHasta16.entities.Persona;
import com.example.Parcial1_ApiRest_VideosHasta16.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseControllerImpl<E extends BaseEntidad, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {
//public abstract class BaseControllerImpl<E extends BaseEntidad, ID extends Serializable> implements BaseController<E, ID> {

    @Autowired
    protected S servicio;

    /**
     * OBTENER TODOS LOS REGISTROS
     *
     * @return ResponseEntity   // Devuelve una lista de todas las personas en el cuerpo de la respuesta.
     * @GetMapping("") // Define una solicitud GET para obtener todos los registros usando el método findAll() de PersonaService.
     */
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaServiceImpl.findAll());

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al obtener el listado de personas. Por favor intente más tarde.");
            error.put("details", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    /**
     * OBTENER UN REGISTRO POR ID
     *
     * @param id // ID del registro a obtener
     * @return ResponseEntity   // Devuelve la persona con el ID especificado en el cuerpo de la respuesta.
     * @GetMapping("/{id}") // Define una solicitud GET para obtener un registro específico mediante el ID en la URI.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaServiceImpl.findById(id));

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al obtener la persona con ID: " + id);
            error.put("details", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }

    /**
     * GUARDAR UN REGISTRO
     *
     * @param entity // Entidad Persona a guardar
     * @return ResponseEntity   // Devuelve la persona guardada en el cuerpo de la respuesta.
     * @PostMapping("") // Define una solicitud POST para guardar un nuevo registro.
     */
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Persona entity) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaServiceImpl.save(entity));

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al guardar la persona.");
            error.put("details", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    /**
     * ACTUALIZAR UN REGISTRO
     *
     * @param id     // ID del registro a actualizar
     * @param entity // Entidad Persona con los nuevos datos
     * @return ResponseEntity   // Devuelve la persona actualizada en el cuerpo de la respuesta.
     * @PutMapping("/{id}") // Define una solicitud PUT para actualizar un registro existente mediante el ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaServiceImpl.update(id, entity));

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al actualizar la persona con ID: " + id);
            error.put("details", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

    /**
     * BORRAR UN REGISTRO
     *
     * @param id // ID del registro a borrar
     * @return ResponseEntity   // Devuelve una respuesta vacía con el código de estado NO_CONTENT si la operación es exitosa.
     * @DeleteMapping("/{id}") // Define una solicitud DELETE para borrar un registro específico mediante el ID en la URI.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(personaServiceImpl.delete(id));
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al eliminar la persona con ID: " + id);
            error.put("details", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error);
        }
    }

}
