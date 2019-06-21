package com.dosideas.service;

import com.dosideas.domain.Provincia;

import java.util.List;

public interface ProvinciaService {

    Provincia buscarPorId(Long id);

    List<Provincia> buscarPorNombre(String nombre);

    List<Provincia> buscarPorNombreConteniendo(String palabra);

    List<Provincia> buscarTodas();

    Provincia agregar(Provincia provincia);


}
