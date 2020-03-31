/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.presentation;

import com.incoorp.service.LibroService;
import com.incoorp.interfaces.InterBean;
import com.incoorp.model.Libro;
import com.sun.glass.events.MouseEvent;
import java.util.ArrayList;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


/**
 *
 * @author incoorp
 */
@Named(value = "libroBean")
@ManagedBean(name = "libroBean")
@RequestScoped
public class LibroBean {
    
    public Logger log = Logger.getLogger(LibroBean.class);
    private InterBean dao = new LibroService();
    
    private String titulo;
    private String autor;
    private Long paginas;
    private String ISBN;
    private String edicion;
    private String descripcion;
    private Libro newLibro = new Libro();
    private List<Libro> ListaLibros = new ArrayList<>();
    
    public String cambiar(){
        FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        
        return "index_1?faces-redirect=true";
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    
    public LibroBean() {
    }
    
    public List<Libro> listar(){
        ListaLibros = dao.getAll();
       return ListaLibros;
    }
    
    public void guardar(ActionEvent e){
         BasicConfigurator.configure();
        newLibro.setAutor(getAutor());
        newLibro.setDescripcion(getDescripcion());
        newLibro.setEdicion(getEdicion());
        newLibro.setISBN(getISBN());
        newLibro.setPaginas(getPaginas());
        newLibro.setTitulo(getTitulo());
        dao.save(getNewLibro());
        log.info("guardado");
        
    }
    
    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public InterBean getDao() {
        return dao;
    }

    public void setDao(InterBean dao) {
        this.dao = dao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getPaginas() {
        return paginas;
    }

    public void setPaginas(Long paginas) {
        this.paginas = paginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Libro getNewLibro() {
        return newLibro;
    }

    public void setNewLibro(Libro newLibro) {
        this.newLibro = newLibro;
    }

    public List<Libro> getListaLibros() {
        return ListaLibros;
    }

    public void setListaLibros(List<Libro> ListaLibros) {
        this.ListaLibros = ListaLibros;
    }
    
    
    
}
