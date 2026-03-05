package ies_alcores.api_swbatallas.controller;

import ies_alcores.api_swbatallas.model.Batallas;
import ies_alcores.api_swbatallas.service.BatallasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batallas")
@AllArgsConstructor
public class BatallasController {

    private BatallasService batallasService;

    // GET /api/batallas
    @GetMapping
    public ResponseEntity<List<Batallas>> getAll() {
        return ResponseEntity.ok(this.batallasService.findAll());
    }

    // GET /api/batallas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Batallas> getById(@PathVariable int id) {
        if (!this.batallasService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.batallasService.findById(id).get());
    }

    // POST /api/batallas
    @PostMapping
    public ResponseEntity<Batallas> create(@RequestBody Batallas batalla) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.batallasService.save(batalla));
    }

    // PUT /api/batallas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Batallas> update(@PathVariable int id, @RequestBody Batallas batalla) {
        if (!this.batallasService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        batalla.setBatalla_id(id);
        return ResponseEntity.ok(this.batallasService.save(batalla));
    }

    // DELETE /api/batallas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!this.batallasService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        this.batallasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}