/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Practica3.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;



/**
 *
 * @author sebas
 */
@Data
@Entity
@Table (name= "arbol")
public class Arbol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private long idArbol;
    private String ruta_Imagen;
    private String nombreComun;
    private String tipoFlor;
    private String durezaMadera;
    private String otraDescripcion;
    private boolean activo;


}   