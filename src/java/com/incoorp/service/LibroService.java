package com.incoorp.service;

import java.util.List;



import com.incoorp.dao.LibroDAO;
import com.incoorp.interfaces.InterBean;
import com.incoorp.interfaces.LibroRepository;
import com.incoorp.model.Libro;

public class LibroService implements InterBean<Libro,String>{

    LibroDAO dao = new LibroDAO();
  
    @Override
    public void save(Libro o) {
        dao.save(o);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public Libro update(Libro o) {
        return dao.update(o);
    }

    @Override
    public List<Libro> getAll() {
        return dao.getAll();
    }

    @Override
    public Libro getOne(String id) {
        return dao.getOne(id);
    }

    
  

}
