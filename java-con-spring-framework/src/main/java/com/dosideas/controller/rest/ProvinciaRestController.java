package com.dosideas.controller.rest;

import com.dosideas.api.Filter;
import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaRestController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/")
    public List<Provincia>  listarTodas(){
        return provinciaService.buscarTodas();
    }

    @GetMapping("/{id}")
    public Provincia listarPorId(@PathVariable("id") Long id){
        return provinciaService.buscarPorId(id);
    }

    /*@GetMapping("/filtro/{palabra}")
    public List<Provincia> listarPorPalabra(@PathVariable("palabra") String palabra){
        return provinciaService.buscarPorNombreConteniendo(palabra);
    }*/

    @PutMapping("/{id}")//Actualiza id existente
    @ResponseStatus(HttpStatus.OK)
    public Provincia actualizar(@PathVariable Long id, @RequestBody Provincia provincia){
        if(provinciaService.buscarPorId(id) != null) {
            provincia.setId(id);
            return provinciaService.agregar(provincia);
        }
        return null;
    }

    @PostMapping //Crea nuevo campo
    @ResponseStatus(HttpStatus.OK)
    public Provincia guardar(@RequestBody Provincia provincia){
        if(provinciaService.buscarPorNombre(provincia.getNombre()).isEmpty()) {
           return provinciaService.agregar(provincia);
        }
        return null;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Provincia> listarPorPalabra(@RequestBody Filter filter){
        return provinciaService.buscarPorNombreConteniendo(filter.getPalabra());
    }


}
