package com.bootcamp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;

    // @Id indica que será la clave primaria
    @Id // @GeneratedValue Autoincremental y no nulo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres")
    private String nombre;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;

   

    // Me faltan conocimientos para implementar imagenes pero se que debe ser tipo
    // String
    private String foto;

    @JsonIgnore
    // El mappedBy indica la clave foranea
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")
    private List<Ingrediente> ingredientes;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "pizza")
    private List<Comentario> comentarios;

    // Constructores
    public Pizza() {
    }

    

    public Pizza(long id,
            @NotEmpty(message = "El campo nombre no puede estar vacio") @Size(min = 4, max = 255, message = "El campo nombre tiene que tener entre 4 y 255 caracteres") String nombre,
            @Min(value = 0, message = "El precio no puede ser negativo") double precio, String foto,
            List<Ingrediente> ingredientes, List<Comentario> comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.foto = foto;
        this.ingredientes = ingredientes;
        this.comentarios = comentarios;
    }



    // SETTERS AND GETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

}
