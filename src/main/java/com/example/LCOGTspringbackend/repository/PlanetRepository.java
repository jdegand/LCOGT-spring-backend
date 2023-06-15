package com.example.LCOGTspringbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LCOGTspringbackend.entity.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Planet findByNameIgnoreCase(String name);
    
}
