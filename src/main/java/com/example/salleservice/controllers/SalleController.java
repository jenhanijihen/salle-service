package com.example.salleservice.controllers;


import com.example.salleservice.models.Salle;
import com.example.salleservice.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/salles")
public class SalleController {
    private final SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<Salle> getAllSalles() {
        return salleService.getAllSalles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> getSalleById(@PathVariable Long id) {
        Salle salle = salleService.getSalleById(id);
        return salle != null ? ResponseEntity.ok(salle) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Salle createSalle(@RequestBody Salle salle) {
        return salleService.createSalle(salle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable Long id, @RequestBody Salle salleDetails) {
        Salle updatedSalle = salleService.updateSalle(id, salleDetails);
        return updatedSalle != null ? ResponseEntity.ok(updatedSalle) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/disponibles")
    public List<Salle> getAvailableSalles() {
        return salleService.getAvailableSalles();
    }

    @GetMapping("/capacite/{capacite}")
    public List<Salle> getSallesByCapacity(@PathVariable Integer capacite) {
        return salleService.getSallesByCapacity(capacite);
    }

    @GetMapping("/type/{type}")
    public List<Salle> getSallesByType(@PathVariable Salle.TypeSalle type) {
        return salleService.getSallesByType(type);
    }
}