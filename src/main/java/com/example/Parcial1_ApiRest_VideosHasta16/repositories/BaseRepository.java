package com.example.Parcial1_ApiRest_VideosHasta16.repositories;

import com.example.Parcial1_ApiRest_VideosHasta16.entities.BaseEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serial;
import java.io.Serializable;

@NoRepositoryBean

public interface BaseRepository<E extends BaseEntidad,ID extends Serializable> extends JpaRepository<E,ID> {
//public interface BaseRepository<E,ID>
//public interface BaseRepository<E extends BaseEntidad,ID extends Serializable>

}
