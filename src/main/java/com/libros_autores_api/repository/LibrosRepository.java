package com.libros_autores_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libros_autores_api.model.Libros;

public interface LibrosRepository extends JpaRepository <Libros, Long>{}
