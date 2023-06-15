package com.example.LCOGTspringbackend.service;

import java.util.List;

import com.example.LCOGTspringbackend.entity.Planet;

public interface PlanetService {

    public Planet savePlanet(Planet planet);

    public List<Planet> getPlanets();

    public Planet getPlanetByName(String name);
    
}
