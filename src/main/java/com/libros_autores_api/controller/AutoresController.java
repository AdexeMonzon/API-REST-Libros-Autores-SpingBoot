package com.libros_autores_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libros_autores_api.model.Autores;
import com.libros_autores_api.service.AutoresService;

@RestController
@RequestMapping("/api/v1/autores")
public class AutoresController {

    private AutoresService controllerAutor;

    public AutoresController(AutoresService controllerAutor) {
        this.controllerAutor = controllerAutor;
    }

    @GetMapping
    public List<Autores> listarAutores(){
        return controllerAutor.listarAutores();
    }

    @PostMapping
    public Autores guardarAutor(@RequestBody Autores autor){
        return controllerAutor.crearAutor(autor);
    }

    @DeleteMapping("/{id}")
    public void eliminarAutorPorId(@PathVariable Long id){
         controllerAutor.eliminarAutor(id);
    }

    @PutMapping
    public Autores editarAutor(@RequestBody Autores autor,@PathVariable Long id){
        return controllerAutor.updatAutores(autor, id);
    }

    @PostMapping("/id")
        public void listarAutoresPorId(@PathVariable Long id){
             controllerAutor.listarAutorPorId(id);
        }
    
    
}
