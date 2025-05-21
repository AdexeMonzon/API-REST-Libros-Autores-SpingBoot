package com.libros_autores_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libros_autores_api.model.Libros;
import com.libros_autores_api.service.LibrosService;

@RestController
@RequestMapping("/api/v1/libros")
public class LibrosController {

    private final LibrosService librosService;

    public LibrosController(LibrosService librosService) {
        this.librosService = librosService;
    }

    @GetMapping
    public List<Libros> listarLibros() {
        return librosService.listarLibros();
    }

    @PostMapping
    public Libros crearLibro(@RequestBody Libros libro) {
        return librosService.crearLibro(libro);
    }

    @PutMapping("/{id}")
    public Libros actualizarLibro(@PathVariable Long id, @RequestBody Libros libro) {
        return librosService.updateLibro(id, libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        librosService.eliminarLibro(id);
    }

    @GetMapping("/buscar")
    public List<Libros> buscarLibros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Integer anioMin,
            @RequestParam(required = false) Integer anioMax,
            @RequestParam(required = false, defaultValue = "anioPublicacion") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String order) {
        return librosService.buscarLibros(titulo, anioMin, anioMax, sortBy, order);
    }


    
}
