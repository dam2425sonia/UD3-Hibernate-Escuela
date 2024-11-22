package com.example;

import java.util.List;
import org.hibernate.Session;

public class Consultar {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Estudiante> estudiantes = session.createQuery("FROM Estudiante", Estudiante.class).list();
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Estudiante: " + estudiante.getNombre() +
                               ", Curso: " + (estudiante.getCurso() != null ? estudiante.getCurso().getNombre() : "Sin curso"));
        }

        session.close();
    }
}
