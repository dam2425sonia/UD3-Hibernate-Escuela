package com.example;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Crear curso
        Curso curso = new Curso();
        curso.setNombre("Matemáticas");

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan Pérez");
        estudiante1.setCurso(curso);

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Ana Gómez");
        estudiante2.setCurso(curso);

        // Asociar estudiantes al curso
         // Lista de nombres de ejemplo
        curso.setEstudiantes(Arrays.asList(estudiante1, estudiante2));
        //curso.setEstudiantes(List.of(estudiante1, estudiante2));

        // Guardar curso (cascada guardará también los estudiantes)
        session.save(curso);

        transaction.commit();
        session.close();
    }
}
