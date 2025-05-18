package com.libros_autores_api.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.libros_autores_api.model.Autores;
import com.libros_autores_api.model.Libros;
import com.libros_autores_api.repository.AutoresRepository;

@Service
public class AutoresService {
    private AutoresRepository repoAutores;

    public AutoresService(AutoresRepository repoAutores){
        this.repoAutores = repoAutores;
    }

    public Autores crearAutor(Autores autor){
        if(repoAutores.existsById(autor.getId()) || repoAutores.existsByNombre(autor.getNombre())){
            throw new NoSuchElementException("No se puede crear este autor, ya existe en la base de datos");
        }else{
            return repoAutores.save(autor);
        }
    }

    public List<Autores> listarAutores(Autores autor) {
        return repoAutores.findAll();
    }


    public void eliminarAutor(Long id){
        if(!repoAutores.existsById(id)){
            throw new NoSuchElementException("No se ha eliminado el autor con el ID: "
                                             + id +
                                            ", no se encuentra en la base de datos");
        }else{
            repoAutores.deleteById(id);
        }
    }

    public Autores listarAutorPorId(Long id){
        if(!repoAutores.existsById(id)){
            throw new NoSuchElementException("No se ha encontrado ningun autor con el ID: "
                                             + id );
        }else{
             return repoAutores.findById(id).orElse(null);
        }
    }

    public Autores updatAutores (Autores datos, Long id){
        if(!repoAutores.existsById(id)){
            throw new NoSuchElementException("No se ha actualizado ningun autor," +
                                            "no se encuentra el autor con el ID: "
                                            + id);
        }else{
            Autores autor = repoAutores.findById(id).orElse(null);
            autor.setNombre(datos.getNombre());
            autor.setNacionalidad(datos.getNacionalidad());
            autor.setLibro(datos.getLibro());
            return repoAutores.save(autor);
        }
    }
}
