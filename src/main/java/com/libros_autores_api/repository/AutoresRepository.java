package com.libros_autores_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libros_autores_api.model.Autores;

public interface AutoresRepository extends JpaRepository <Autores, Long>{
    Optional<Autores> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
