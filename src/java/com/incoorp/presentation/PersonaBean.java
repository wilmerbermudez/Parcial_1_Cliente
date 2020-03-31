/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.presentation;

import com.incoorp.service.PersonaService;
import com.incoorp.interfaces.InterBean;
import com.incoorp.interfaces.InterBeanPersona;
import com.incoorp.model.Persona;
import com.incoorp.model.Reserva;
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
@Named(value = "personaBean")
@ManagedBean(name = "personaBean")
@RequestScoped
public class PersonaBean {
    
    public Logger log = Logger.getLogger(PersonaBean.class);
    private InterBeanPersona dao = new PersonaService();
    
    private String id;
    private String nombre;
    private Reserva reserva;
    private Persona newPersona = new Persona();
    private List<Persona> ListaPersonas = new ArrayList<>();
    
    public String cambiar(){
        FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        
        return "index_1?faces-redirect=true";
    }
    

    
    
    public List<Persona> listar(){
       return dao.getAll();
    }
    
    public void guardar(ActionEvent e){
         BasicConfigurator.configure();
        newPersona.setId(getId());
        newPersona.setNombre(getNombre());
        dao.save(getNewPersona());
        log.info("guardado");
        
    }
    
    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public InterBeanPersona getDao() {
        return dao;
    }

    public void setDao(InterBeanPersona dao) {
        this.dao = dao;
    }


    public Persona getNewPersona() {
        return newPersona;
    }

    public void setNewPersona(Persona newPersona) {
        this.newPersona = newPersona;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Persona> getListaPersonas() {
        return ListaPersonas;
    }

    public void setListaPersonas(List<Persona> ListaPersonas) {
        this.ListaPersonas = ListaPersonas;
    }
    
    
    
}
