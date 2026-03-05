package ies_alcores.api_swbatallas.service;

import ies_alcores.api_swbatallas.model.Batallas;
import ies_alcores.api_swbatallas.repository.BatallasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BatallasService {

    private BatallasRepository batallasRepository;

    public List<Batallas> findAll() {
        return this.batallasRepository.findAll();
    }

    public Optional<Batallas> findById(final int id) {
        return this.batallasRepository.findById(id);
    }

    public Batallas save(final Batallas batalla) {
        return this.batallasRepository.save(batalla);
    }

    public void delete(final int id) {
        this.batallasRepository.deleteById(id);
    }
}