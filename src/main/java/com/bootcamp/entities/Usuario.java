package com.bootcamp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario implements Serializable{

    private static final long serialVersionUID = 3L;
    @Id // @GeneratedValue Autoincremental y no nulo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotEmpty(message = "El campo email no puede estar vacio")
    private String email;
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Size(min = 3, max = 15, message = "El campo nombre tiene que tener entre 3 y 15 caracteres")
    private String nombre;
    @NotEmpty(message = "El campo apellido1 no puede estar vacio")
    @Size(min = 4, max = 15, message = "El campo apellido1 tiene que tener entre 4 y 255 caracteres")
    private String apellido1;
    @Size(min = 4, max = 15, message = "El campo apellido 2 tiene que tener entre 4 y 255 caracteres")
    private String apellido2;
    @NotEmpty(message = "El campo contraseña no puede estar vacio")
    private String contraseña;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "usuario")
    private List<Comentario> comentarios;


    
    

    public Usuario(long id, @NotEmpty(message = "El campo email no puede estar vacio") String email,
            @NotEmpty(message = "El campo nombre no puede estar vacio") @Size(min = 3, max = 15, message = "El campo nombre tiene que tener entre 3 y 15 caracteres") String nombre,
            @NotEmpty(message = "El campo apellido1 no puede estar vacio") @Size(min = 4, max = 15, message = "El campo apellido1 tiene que tener entre 4 y 255 caracteres") String apellido1,
            @Size(min = 4, max = 15, message = "El campo apellido 2 tiene que tener entre 4 y 255 caracteres") String apellido2,
            @NotEmpty(message = "El campo contraseña no puede estar vacio") String contraseña,
            List<Comentario> comentarios) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.contraseña = contraseña;
        this.comentarios = comentarios;
    }

    public Usuario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Comentario> getComentario() {
        return comentarios;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentarios = comentario;
    }

    public Usuario(@NotEmpty(message = "El campo email no puede estar vacio") String email,
            @NotEmpty(message = "El campo nombre no puede estar vacio") @Size(min = 3, max = 15, message = "El campo nombre tiene que tener entre 3 y 15 caracteres") String nombre,
            @NotEmpty(message = "El campo apellido1 no puede estar vacio") @Size(min = 4, max = 15, message = "El campo apellido1 tiene que tener entre 4 y 255 caracteres") String apellido1,
            @Size(min = 4, max = 15, message = "El campo apellido 2 tiene que tener entre 4 y 255 caracteres") String apellido2,
            @NotEmpty(message = "El campo contraseña no puede estar vacio") String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
