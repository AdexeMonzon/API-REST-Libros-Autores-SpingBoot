package com.libros_autores_api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Autor")
public class Autores {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nacionalidad;
    
    @OneToMany(mappedBy = "autor")
    private List<Libros> Libro;

    public Autores(){}

    public Autores(Long id, String nombre, String nacionalidad, List<Libros> libro) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        Libro = libro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libros> getLibro() {
        return Libro;
    }

    public void setLibro(List<Libros> libro) {
        Libro = libro;
    }

    
    
}
