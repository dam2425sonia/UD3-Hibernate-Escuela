package com.example;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Cursos") // Mapea con la tabla 'cursos'
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Clave primaria con autoincremento
    private int id;

    @Column(name = "nombre", nullable = false, length = 100) // Mapea la columna 'nombre'
    private String nombre;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes; // Relación con Estudiantes

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}

