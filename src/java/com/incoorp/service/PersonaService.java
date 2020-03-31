package com.incoorp.service;

import java.util.List;



import com.incoorp.dao.PersonaDAO;
import com.incoorp.interfaces.InterBean;
import com.incoorp.interfaces.InterBeanPersona;
import com.incoorp.model.Persona;
import com.incoorp.model.Reserva;

public class PersonaService implements InterBeanPersona<Persona,String>{

    PersonaDAO dao = new PersonaDAO();
  
    @Override
    public void save(Persona o) {
        dao.save(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public Persona update(Persona o) {
        return dao.update(o);
    }

    @Override
    public List<Persona> getAll() {
        return dao.getAll();
    }

    @Override
    public Persona getOne(String id) {
        return dao.getOne(id);
    }
    
    @Override
    public List<Persona> getAllWithReserva() {
        return dao.getAllWithReserva();
    }
}
