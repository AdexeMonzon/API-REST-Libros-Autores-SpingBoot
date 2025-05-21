package com.libros_autores_api.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.domain.Sort;
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

    public void eliminarLibro (long id) {
        if (!librosRepository.existsById(id)) {
            throw new NoSuchElementException("El libro con el id " + id + " no existe");
        }
        librosRepository.deleteById(id);
    }

    public List<Libros> buscarLibros(String titulo, Integer anioMin, Integer anioMax, String sortBy, String order) {
    String title = (titulo == null) ? "" : titulo;
    int min = (anioMin == null) ? 0 : anioMin;
    int max = (anioMax == null) ? Integer.MAX_VALUE : anioMax;
    Sort.Direction dir = "desc".equalsIgnoreCase(order) ? Sort.Direction.DESC : Sort.Direction.ASC;
    Sort sort = Sort.by(dir, sortBy == null ? "anioPublicacion" : sortBy);
    return librosRepository.findByTituloContainingIgnoreCaseAndAnioPublicacionBetween(title, min, max, sort);
    }
}
