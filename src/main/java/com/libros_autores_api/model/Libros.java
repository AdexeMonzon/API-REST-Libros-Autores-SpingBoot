package com.libros_autores_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String ISBN;
    private int anioPublicacion;

    @ManyToOne
    @JoinColumn(name = "Autor")
    @JsonBackReference
    private Autores autor;

    public Libros() {}

    public Libros(Long id, String titulo, String iSBN, int anioPublicacion, Autores autor) {
        this.id = id;
        this.titulo = titulo;
        ISBN = iSBN;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getISBN() {return ISBN;}

    public void setISBN(String iSBN) {ISBN = iSBN;}

    public int getAnioPublicacion() {return anioPublicacion;}

    public void setAnioPublicacion(int anioPublicacion) {this.anioPublicacion = anioPublicacion;}

    public Autores getAutor() {return autor;}

    public void setAutor(Autores autor) {this.autor = autor;}
}
