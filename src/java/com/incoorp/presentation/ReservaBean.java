/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.presentation;

import com.incoorp.service.ReservaService;
import com.incoorp.interfaces.InterBean;
import com.incoorp.interfaces.InterBeanPersona;
import com.incoorp.interfaces.InterBeanReserva;
import com.incoorp.model.Libro;
import com.incoorp.model.Persona;
import com.incoorp.model.Reserva;
import com.incoorp.service.LibroService;
import com.incoorp.service.PersonaService;
import com.sun.glass.events.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author incoorp
 */

@ManagedBean(name = "reservaBean")
@RequestScoped
public class ReservaBean {
    
    public Logger log = Logger.getLogger(ReservaBean.class);
    private InterBean daoLibro = new LibroService();
    private InterBeanPersona daoPersona = new PersonaService();
    private InterBeanReserva daoReserva= new ReservaService();
    
    private Long id;
    private Date fechaPestramo;
    private Date fechaEntrega;
    
    
    private Libro libroSeleccionado = new Libro();
    private final List<SelectItem> librosCombo;
    private static List<Libro> libros = new ArrayList<>();

   
    public void guardarItem(){
        log.info(libroSeleccionado.getISBN());
        Libro l = new Libro(libroSeleccionado.getISBN());
        ReservaBean.libros.add(l);

        log.info(libros);
    }
    
    public void eliminarItem(Libro o){
        ReservaBean.libros.remove(o);
    }
    
    
    
    private Reserva newReserva = new Reserva();
    private List<Reserva> ListaReservas = new ArrayList<>();
    
    public String cambiar(){
        FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        
        return "index_1?faces-redirect=true";
    }

    public ReservaBean() {
        BasicConfigurator.configure();
        this.librosCombo= new ArrayList<SelectItem>();
    }
    
    
    
    
    public List<Reserva> listar(){
       return daoReserva.getAll();
    }
    
    public List<Persona> listarReservasActivas(){
        return daoPersona.getAllWithReserva();
    }
    
    public void guardar(ActionEvent e){
         BasicConfigurator.configure();
         
        newReserva.setFechaPrestamo(new Date());
        newReserva.setFechaEntrega(new Date());
        newReserva.setLibros(getLibros());
        newReserva.setId(daoReserva.getMaxId());
        Persona p = (Persona) daoPersona.getOne(id.toString());
            p.setReserva(newReserva);
            daoPersona.save(p);
        log.info("guardado");
        
    }
    
    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public InterBeanReserva getDao() {
        return daoReserva;
    }

    public void setDao(InterBeanReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public Reserva getNewReserva() {
        return newReserva;
    }

    public void setNewReserva(Reserva newReserva) {
        this.newReserva = newReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPestramo() {
        return fechaPestramo;
    }

    public void setFechaPestramo(Date fechaPestramo) {
        this.fechaPestramo = fechaPestramo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<Reserva> getListaReservas() {
        return ListaReservas;
    }

    public void setListaReservas(List<Reserva> ListaReservas) {
        this.ListaReservas = ListaReservas;
    }

    public InterBean getDaoLibro() {
        return daoLibro;
    }

    public void setDaoLibro(InterBean daoLibro) {
        this.daoLibro = daoLibro;
    }

    public Libro getLibroSeleccionado() {
        return libroSeleccionado;
    }

    public void setLibroSeleccionado(Libro libroSeleccionado) {
        this.libroSeleccionado = libroSeleccionado;
    }

  
    
     public List<SelectItem> getLibrosCombo() {
         List<Libro> libros = daoLibro.getAll();
         librosCombo.clear();

         for (Libro l : libros) {
             SelectItem libroItem = new SelectItem(l.getISBN(), l.getTitulo());
             this.librosCombo.add(libroItem);
         }
         return librosCombo;
    }

    public void setLibrosCombo(List<SelectItem> librosCombo) {
        librosCombo = librosCombo;
    }

    public List<Libro> getLibros() {
        return ReservaBean.libros;
    }

    public void setLibros(List<Libro> libros) {
        ReservaBean.libros = libros;
    }
    
    
    
    

}
