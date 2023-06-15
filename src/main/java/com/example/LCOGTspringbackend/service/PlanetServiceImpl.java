package com.example.LCOGTspringbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LCOGTspringbackend.entity.Planet;
import com.example.LCOGTspringbackend.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public Planet savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public List<Planet> getPlanets() {
        return planetRepository.findAll();
    }

    @Override
    public Planet getPlanetByName(String name) {
        return planetRepository.findByNameIgnoreCase(name);
    }
    
}
