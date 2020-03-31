package com.incoorp.dao;

import java.util.List;


import com.incoorp.model.Libro;
import com.incoorp.Util.JPAUtil;
import com.incoorp.interfaces.LibroRepository;
import org.hibernate.Session;

public class LibroDAO implements LibroRepository{

    
            Session session = JPAUtil.openSession();
    @Override
    public void save(Libro o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
    }

    @Override
    public Boolean delete(String id) {
        session.beginTransaction().begin();
        Libro o = getOne(id);
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Libro update(Libro o) {
        session.beginTransaction();
        Libro l = (Libro) session.merge(o);
        session.getTransaction().commit();
        return o;
    }

    @Override
    public List<Libro> getAll() {
        session.beginTransaction();
        List<Libro> listaLibros;
        listaLibros = session.createQuery("SELECT o FROM Libro o").list();
        session.getTransaction().commit();
        return listaLibros;
    }

    @Override
    public Libro getOne(String id) {

        session.beginTransaction();
        return (Libro) session.get(Libro.class, id);
    }
        
}
