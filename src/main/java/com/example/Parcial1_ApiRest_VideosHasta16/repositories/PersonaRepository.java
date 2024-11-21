package com.example.Parcial1_ApiRest_VideosHasta16.repositories;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository <Persona,Long> {
//public interface PersonaRepository extends JpaRepository <Persona,Long> {    // 9.2 //patron DAO que propone separar por completo la logica de negocio de nuestra app de la logica para acceder a la BD  el persona repository se va a comunicar con la BD

}
