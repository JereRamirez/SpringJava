package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    private ProvinciaRepository provinciaRepository;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    @Override
    public Provincia buscarPorId(Long id){
        return provinciaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Provincia> buscarPorNombre(String nombre){
        return provinciaRepository.findByNombre(nombre);
    }

    @Override
    public List<Provincia> buscarPorNombreConteniendo(String palabra){
        return provinciaRepository.findByNombreContainingIgnoreCase(palabra);
    }

    @Override
    public List<Provincia> buscarTodas(){
        return provinciaRepository.findAll();
    }

    @Override
    public Provincia agregar(Provincia provincia){
        return provinciaRepository.save(provincia);
    }



}
