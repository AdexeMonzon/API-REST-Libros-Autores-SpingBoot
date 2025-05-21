package com.libros_autores_api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.libros_autores_api.model.Libros;

public interface LibrosRepository extends JpaRepository <Libros, Long>{
    List<Libros> findByTituloContainingIgnoreCaseAndAnioPublicacionBetween(
        String titulo, Integer anioMin, Integer anioMax, Sort sort
    );
}
