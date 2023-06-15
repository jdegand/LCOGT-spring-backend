package com.example.LCOGTspringbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LCOGTspringbackend.entity.Planet;
import com.example.LCOGTspringbackend.service.PlanetService;

import jakarta.validation.Valid;

@RestController
public class PlanetController {

    @Autowired
    private PlanetService planetService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/planets")
    public Planet savePlanet(@Valid @RequestBody Planet planet){
        return planetService.savePlanet(planet);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    public Map<String,List<Planet>> getPlanets(){
        Map<String, List<Planet>> entries = new HashMap<>();
        entries.put("entries", planetService.getPlanets());
        return entries;
        // if you just return planetService.getPlanets() -> error in angular frontend
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/planets/detail/{name}")
    public Planet getPlanetByName(@PathVariable("name") String planetName) {
       return planetService.getPlanetByName(planetName);
    }

}
