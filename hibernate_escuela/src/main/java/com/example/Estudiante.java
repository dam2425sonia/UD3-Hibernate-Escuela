package com.example;

import javax.persistence.*;

@Entity
@Table(name = "Estudiantes") // Mapea con la tabla 'estudiantes'
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Clave primaria con autoincremento
    private int id;

    @Column(name = "nombre", nullable = false, length = 100) // Mapea la columna 'nombre'
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id") // Define la clave foránea hacia 'cursos'
    private Curso curso; // Relación con Curso

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

