package com.bootcamp.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id // @GeneratedValue Autoincremental y no nulo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Size(max = 255, message = "El campo  no puede tener mas de 255 caracteres")
    private String texto;
    @Min(value = 0, message = "La puntuacion debe ser positiva ")
    @Max(value = 10, message = "El rango de la puntuacion es (0-10)")
    private int puntuacion;

    private LocalDate fecha;

    @NotNull(message = "El producto tiene que tener una presentación")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull(message = "El producto tiene que tener una presentación")
    private Pizza pizza;

    public Comentario() {
    }

    
    public Comentario(long id,
            @Size(max = 255, message = "El campo  no puede tener mas de 255 caracteres") String texto,
            @Min(value = 0, message = "La puntuacion debe ser positiva ") @Max(value = 10, message = "El rango de la puntuacion es (0-10)") int puntuacion,
            LocalDate fecha, Usuario usuario,
            @NotNull(message = "El producto tiene que tener una presentación") Pizza pizza) {
        this.id = id;
        this.texto = texto;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.usuario = usuario;
        this.pizza = pizza;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    
    
    

    
}
