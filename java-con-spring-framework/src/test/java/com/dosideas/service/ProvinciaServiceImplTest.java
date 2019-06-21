package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceImplTest {

    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_conIdExistente_retornaProvincia(){

        long id = 1;

        Provincia provincia = provinciaService.buscarPorId(id);

        assertNotNull(provincia);
        assertEquals(1, provincia.getId());
    }

    @Test
    public void buscarPorId_conIdInexistente_retornaNull(){

        long id = -1;
        Provincia provincia = provinciaService.buscarPorId(id);

        assertNull(provincia);
    }

    @Test
    public void buscarPorNombre_conNombreExistente_retornaProvincia(){

        Provincia provincia = provinciaService.buscarPorNombre("Buenos Aires").get(0);

        assertEquals("Buenos Aires", provincia.getNombre());

    }

    @Test
    public void buscarPorNombreConteniendo_conPalabraExistente_retornaListaProvincia(){
        List<Provincia> provincias = provinciaService.buscarPorNombreConteniendo("san");

        assertEquals(3, provincias.size());
    }

}
