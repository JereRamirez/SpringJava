package com.dosideas.controller.rest;

import com.dosideas.domain.Pais;
import com.dosideas.exception.PaisNoEncontradoException;
import com.dosideas.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Este es un controlador de presentación (que se define anotándolo con @RestController),
 * que devuelve JSON al cliente.
 * Estos controladores se utilizan para retornar datos en algún formato que sea
 * fácil de consumir por otro programa (a diferencia de un @Controller de vista,
 * que retorna HTML para que sea visualizado por un ser humano).
 *
 * La anotación @RequestMapping en un método indica que ese método se invoca
 * cuando se recibe una petición HTTP con esa dirección. El método en cuestión
 * devuelve un objeto, que será transformado al formato JSON y retornado al
 * invocante.
 */
@RestController
@RequestMapping("/api/pais")
public class PaisRestController {

    @Autowired
    private PaisService paisService;

    /*
        GET-POST-PUT-DELETE
        Path variable -> /api/pais/1 el 1 es el path variable, lo sabe por el template path que se crea
                        el mismo se crea /api/pais + /{id}


        GET-POST-PUT-DELETE
        @RequestParam
        Request Parameter -> /api/pais?nombre=San&pais=Brasil

        buscarPorNombreYNombrePais(@RequestParam String nombre, @RequestParam String pais)

        POST-PUT
        @RequestBody

        crear(@RequestBody Provincia provincia)

        @GetMapping
        @PostMapping
        @PutMapping
        @DeleteMapping

     */


    @GetMapping("/{id}")
    public Pais buscarPorId(@PathVariable Long id) throws PaisNoEncontradoException {
        Pais pais = paisService.buscarPorId(id);
        if (pais == null) {
            throw new PaisNoEncontradoException("Pais no encontrado");
        }
        return pais;
    }
}
