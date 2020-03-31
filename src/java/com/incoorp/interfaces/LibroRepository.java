/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.interfaces;

import com.incoorp.model.Libro;
import java.util.List;

/**
 *
 * @author utp
 * @param <T>
 * @param <K>
 */
public interface LibroRepository {
    void save(Libro o);
    Boolean delete(String id);
    Libro update(Libro o);
    List<Libro> getAll();
    Libro getOne(String id);
}
