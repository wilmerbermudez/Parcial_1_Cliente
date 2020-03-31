package com.incoorp.dao;

import java.util.List;


import com.incoorp.Util.JPAUtil;
import com.incoorp.interfaces.PersonaRepository;
import com.incoorp.model.Persona;
import com.incoorp.model.Reserva;
import org.hibernate.Session;

public class PersonaDAO implements PersonaRepository{

    Session session  = JPAUtil.openSession();
    @Override
    public void save(Persona p) {
        session.persist(p);
        session.getTransaction().commit();
    }

    @Override
    public Boolean delete(String id) {
        Persona o = getOne(id);
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Persona update(Persona p) {
        Persona pe = (Persona) session.merge(p);
        session.getTransaction().commit();
        return pe;
    }

    @Override
    public List<Persona> getAll() {
        session.beginTransaction();
        List<Persona> listaPersona;
        listaPersona = session.createQuery("SELECT o FROM Persona o").list();
        session.getTransaction().commit();
        return listaPersona;
    }

    @Override
    public Persona getOne(String id) {
        session.beginTransaction();
        return (Persona) session.get(Persona.class, id);
    }
    
    @Override
    public List<Persona> getAllWithReserva() {
        session.beginTransaction();
        List<Persona> listaPersona;
        listaPersona = session.createQuery("SELECT o FROM Persona o WHERE o.reserva IS NOT NULL").list();
        session.getTransaction().commit();
        return listaPersona;
    }
        
}
