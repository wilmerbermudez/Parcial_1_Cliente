/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author incoorp
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    @Id
    String id;
    @Column(name = "nombre")
    String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserva",referencedColumnName = "id",updatable = true)
    Reserva reserva;

    public Persona(String id, String nombre, Reserva reserva) {
        this.id = id;
        this.nombre = nombre;
        this.reserva = reserva;
    }

    public Persona() {
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

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", reserva=" + reserva + '}';
    }

    
    
}
