/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Practica3.Dao;

import com.Practica3.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface ArbolDao extends JpaRepository<Arbol,Long> {
    
}
