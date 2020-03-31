/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.interfaces;

import com.incoorp.model.Libro;
import com.incoorp.model.Reserva;
import java.util.List;

/**
 *
 * @author utp
 * @param <T>
 * @param <K>
 */
public interface ReservaRepository {
    void save(Reserva o);
    Boolean delete(Long id);
    Reserva update(Reserva o);
    List<Reserva> getAll();
    Reserva getOne(Long id);
    Long getMaxId();
}
