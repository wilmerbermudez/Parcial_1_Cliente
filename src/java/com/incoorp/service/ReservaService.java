package com.incoorp.service;

import java.util.List;




import com.incoorp.dao.ReservaDAO;
import com.incoorp.interfaces.InterBean;
import com.incoorp.interfaces.InterBeanReserva;
import com.incoorp.interfaces.ReservaRepository;
import com.incoorp.model.Reserva;

public class ReservaService implements InterBeanReserva<Reserva,Long>{

    ReservaDAO dao = new ReservaDAO();
  
    @Override
    public void save(Reserva o) {
        dao.save(o);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Reserva update(Reserva o) {
        return dao.update(o);
    }

    @Override
    public List<Reserva> getAll() {
        return dao.getAll();
    }

    @Override
    public Reserva getOne(Long id) {
        return dao.getOne(id);
    }
    
    @Override
    public Long getMaxId(){
        return dao.getMaxId();
    }

}
