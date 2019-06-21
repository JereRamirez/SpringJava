package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    List<Provincia> findByNombre(String provinciaName);

    List<Provincia> findByNombreContainingIgnoreCase(String palabra);

}
