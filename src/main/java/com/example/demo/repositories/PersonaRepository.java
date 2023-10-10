package com.example.demo.repositories;

import com.example.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    //Anotacion con metodo Query
    List<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido, Pageable pageable);

    //Query JPQL PARAMETROS INDEXADOS
    @Query (value= "SELECT p FROM Persona p WHERE p.nombre LIKE'%:filtro%' OR p.apellido LIKE'%:filtro%'")
    List<Persona> serach(@Param("filtro") String filtro);
    @Query (value= "SELECT p FROM Persona p WHERE p.nombre LIKE'%:filtro%' OR p.apellido LIKE'%:filtro%'")
    Page<Persona> serach(@Param("filtro") String filtro,Pageable pageable);

    //JPQL parametros nombrados
  /* @Query (value= "SELECT p FROM Persona p WHERE p.nombre LIKE'%:filtro%' OR p.apellido LIKE'%:filtro%'")
    List<Persona> serach(@Param("filtro")String filtro); */

    //Con native query
    @Query (
            value= "SELECT * FROM Persona p WHERE p.nombre LIKE'%:filtro%' OR p.apellido LIKE'%:filtro%'",
            nativeQuery = true
    )
    List<Persona> serachNativo(@Param("filtro") String filtro);
    @Query (
            value= "SELECT * FROM Persona p WHERE p.nombre LIKE'%:filtro%' OR p.apellido LIKE'%:filtro%'",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true

    )
    Page<Persona> serachNativo(@Param("filtro") String filtro, Pageable pageable);

}
