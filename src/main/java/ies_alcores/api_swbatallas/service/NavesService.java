package ies_alcores.api_swbatallas.service;

import ies_alcores.api_swbatallas.model.Naves;
import ies_alcores.api_swbatallas.repository.NavesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NavesService {

    private NavesRepository navesRepository;

    public List<Naves> findAll() {
        return this.navesRepository.findAll();
    }

    public Optional<Naves> findById(final int id) {
        return this.navesRepository.findById(id);
    }

    public Naves save(final Naves nave) {
        return this.navesRepository.save(nave);
    }

    public void delete(final int id) {
        this.navesRepository.deleteById(id);
    }

    // Query 1: Naves por facción
    public List<Naves> findByFaccion(final String faccion) {
        return this.navesRepository.findByFaccion(faccion);
    }

    // Query 2: Naves más grandes que una longitud dada
    public List<Naves> findByLongitudGreaterThan(final double longitud) {
        return this.navesRepository.findByLongitud_mGreaterThan(longitud);
    }

    // Query 3: Naves por clase y facción
    public List<Naves> findByClaseAndFaccion(final String clase, final String faccion) {
        return this.navesRepository.findByClaseAndFaccion(clase, faccion);
    }
}