package com.example.Parcial1_ApiRest_VideosHasta16.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Localidad extends BaseEntidad{

    @Column(name = "denominacion")
    private String denominacion;
}

