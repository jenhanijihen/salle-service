package com.example.salleservice.services;


import com.example.salleservice.models.Salle;
import com.example.salleservice.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    @Autowired
    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    public Salle getSalleById(Long id) {
        return salleRepository.findById(id).orElse(null);
    }

    public Salle createSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    public Salle updateSalle(Long id, Salle salleDetails) {
        Salle salle = salleRepository.findById(id).orElse(null);
        if (salle != null) {
            salle.setNom(salleDetails.getNom());
            salle.setCapacite(salleDetails.getCapacite());
            salle.setType(salleDetails.getType());
            salle.setDisponible(salleDetails.getDisponible());
            return salleRepository.save(salle);
        }
        return null;
    }

    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    public List<Salle> getAvailableSalles() {
        return salleRepository.findByDisponible(true);
    }

    public List<Salle> getSallesByCapacity(Integer capacite) {
        return salleRepository.findByCapaciteGreaterThanEqual(capacite);
    }

    public List<Salle> getSallesByType(Salle.TypeSalle type) {
        return salleRepository.findByType(type);
    }
}