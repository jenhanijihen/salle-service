package com.example.salleservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true ,nullable = false)
    private String nom;

    @Column(nullable = false)
    private Integer capacite;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeSalle type;

    @Column(nullable = false)
    private Boolean disponible = true;

    public enum TypeSalle {
        STANDARD,
        CONFERENCE,
        FORMATION,
        REUNION,
        AUDITORIUM
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public TypeSalle getType() {
        return type;
    }

    public void setType(TypeSalle type) {
        this.type = type;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

}
