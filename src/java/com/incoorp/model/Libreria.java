/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incoorp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author incoorp
 */
@Entity
@Table(name = "libreria")
public class Libreria implements Serializable {
    @Id
    Long id;
    @Column(name = "direccion")
    String direccion;
}
