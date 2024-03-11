/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Practica3.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sebas
 */
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-49ad7.appspot.com";

    //Esta es la ruta básica de este proyecto practica
    final String rutaSuperiorStorage = "practica3";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "practica-49ad7-firebase-adminsdk-vo1ie-29bc22bf6a.json";
}