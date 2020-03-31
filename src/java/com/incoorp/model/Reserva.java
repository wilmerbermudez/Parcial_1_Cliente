/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author incoorp
 */
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {
    @Id
    Long id;
    @Column(name = "fechaPrestamo")
    Date fechaPrestamo;
    @Column(name = "fechaEntrega")
    Date fechaEntrega;
    @OneToMany(cascade = CascadeType.ALL)
    @Column()
    List<Libro> libros;

    public Reserva(Long id, Date fechaPrestamo, Date fechaEntrega, List<Libro> libros) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.libros = libros;
    }

    public Reserva() {
    }
   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", libros=" + libros + '}';
    }
    
    
}
