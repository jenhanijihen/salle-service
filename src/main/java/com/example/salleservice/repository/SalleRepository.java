package com.example.salleservice.repository;

import com.example.salleservice.models.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
    List<Salle> findByDisponible(Boolean disponible);
    List<Salle> findByCapaciteGreaterThanEqual(Integer capacite);
    List<Salle> findByType(Salle.TypeSalle type);
}