package com.incoorp.dao;

import java.util.List;


import com.incoorp.Util.JPAUtil;
import com.incoorp.interfaces.ReservaRepository;
import com.incoorp.model.Reserva;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class ReservaDAO implements ReservaRepository{

    Session session  = JPAUtil.openSession();
    @Override
    public void save(Reserva r) {
        session.persist(r);
        session.getTransaction().commit();
    }

    @Override
    public Boolean delete(Long id) {
        Reserva re = getOne(id);
        session.delete(re);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Reserva update(Reserva r) {
        session.beginTransaction();
        Reserva re = (Reserva) session.merge(r);
        session.getTransaction().commit();
        return re;
    }

    @Override
    public List<Reserva> getAll() {
        List<Reserva> listaReserva;
        listaReserva = session.createQuery("SELECT o FROM Reserva o").list();
        session.getTransaction().commit();
        return listaReserva;
    }

    @Override
    public Reserva getOne(Long id) {
        session.beginTransaction();
        return (Reserva) session.get(Reserva.class, id);
    }

    @Override
    public Long getMaxId() {
        session.beginTransaction();
        Criteria c = session.createCriteria(Reserva.class);
        c.addOrder(Order.desc("id"));
        c.setMaxResults(1);
        Reserva r = (Reserva)c.uniqueResult();
        session.getTransaction().commit();
        if(r != null){
            
            return r.getId() + 1;
        }
        return 1L;
    }
    
        
}
