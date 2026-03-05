package ies_alcores.api_swbatallas.repository;

import ies_alcores.api_swbatallas.model.Naves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NavesRepository extends JpaRepository<Naves, Integer> {

    // Query 1: Buscar naves por facción
    List<Naves> findByFaccion(String faccion);

    // Query 2: Buscar naves más grandes que una longitud dada
    @Query("SELECT n FROM Naves n WHERE n.longitud_m > :longitud")
    List<Naves> findByLongitud_mGreaterThan(double longitud);

    // Query 3: Buscar naves por clase y facción
    @Query("SELECT n FROM Naves n WHERE n.clase = :clase AND n.faccion = :faccion")
    List<Naves> findByClaseAndFaccion(@Param("clase") String clase, @Param("faccion") String faccion);
}