package ies_alcores.api_swbatallas.controller;

import ies_alcores.api_swbatallas.model.Naves;
import ies_alcores.api_swbatallas.service.NavesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/naves")
@AllArgsConstructor
public class NavesController {

    private NavesService navesService;

    // GET /api/naves
    @GetMapping
    public ResponseEntity<List<Naves>> getAll() {
        return ResponseEntity.ok(this.navesService.findAll());
    }

    // GET /api/naves/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Naves> getById(@PathVariable int id) {
        if (!this.navesService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.navesService.findById(id).get());
    }

    // POST /api/naves
    @PostMapping
    public ResponseEntity<Naves> create(@RequestBody Naves nave) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.navesService.save(nave));
    }

    // PUT /api/naves/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Naves> update(@PathVariable int id, @RequestBody Naves nave) {
        if (!this.navesService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        nave.setNave_id(id);
        return ResponseEntity.ok(this.navesService.save(nave));
    }

    // DELETE /api/naves/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!this.navesService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        this.navesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}