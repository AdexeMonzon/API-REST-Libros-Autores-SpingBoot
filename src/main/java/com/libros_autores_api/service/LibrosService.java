package com.libros_autores_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.libros_autores_api.model.Libros;
import com.libros_autores_api.repository.LibrosRepository;

@Service
public class LibrosService {
    
    LibrosRepository librosRepository;
    
    public LibrosService(LibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }


    public Libros crearLibro (Libros libro) {
        return librosRepository.save(libro);
    }


    public List<Libros> listarLibros () {
        return librosRepository.findAll();
    }

    public Libros updateLibro (long id, Libros libro) {
        if (!librosRepository.existsById(id)) {
            throw new NoSuchElementException("El libro con el id " + id + " no existe");
        }

        libro.setId(id);
        return librosRepository.save(libro);
    }


    public List<Libros> buscarLibros(String titulo, Integer anioPublicacion, String sortBy, String order) {
    List<Libros> resultado = new ArrayList<>();

    for (Libros libro : listarLibros()) {
        boolean coincide = true;
        if (titulo != null && !titulo.isEmpty()) {
            if (!libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                coincide = false;
            }
        }
        if (anioPublicacion != null) {
            if (libro.getAnioPublicacion() != anioPublicacion) {
                coincide = false;
            }
        }
        if (coincide) {
            resultado.add(libro);
        }
    }

    

    return resultado;
}




    
}
