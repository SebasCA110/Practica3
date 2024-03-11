/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Practica3.controller;

import com.Practica3.domain.Arbol;
import com.Practica3.service.ArbolService;
import com.Practica3.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sebas
  
@RestController
@Slf4j
@RequestMapping("/arboles")
public class ArbolController {

    @Autowired
    private Services arbolService;

    @GetMapping("/")
    public List<Arbol> listarArboles() {
        return arbolService.listarArboles();
    }

    @PostMapping("/")
    public Arbol crearArbol(@RequestBody Arbol arbol) {
        return arbolService.crearArbol(arbol);
    }

    @PutMapping("/{id}")
    public Arbol actualizarArbol(@PathVariable Long id, @RequestBody Arbol arbol) {
        return arbolService.actualizarArbol(id, arbol);
    }

    @DeleteMapping("/{id}")
    public void eliminarArbol(@PathVariable Long id) {
        arbolService.eliminarArbol(id);
    }
}
*/ 

@Controller
@Slf4j
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var arbol = arbolService.getArbol(false);
        model.addAttribute("arbol", arbol);
        model.addAttribute("totalArboles", arbol.size());
        return "/arbol/listado";
    }

    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRuta_Imagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "arbol",
                            arbol.getIdArbol()));
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }
}