package com.example.LCOGTspringbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.LCOGTspringbackend.entity.Planet;
import com.example.LCOGTspringbackend.repository.PlanetRepository;

@SpringBootTest
public class PlanetServiceTest {

    @MockBean
    private PlanetRepository planetRepository;

    @Autowired
    private PlanetService planetService;

    @BeforeEach
    void setUp(){
        Planet planet = Planet.builder()
        .name("Mars")
        .size(new BigDecimal(0.107)) // if just put numbers -> double
        .distance(new BigDecimal(1.41))
        .description("Mars is the dry and inhospitable 4th planet from the Sun. It is here that Matt Damon grew potatoes using his own poop.")
        .build();

        Mockito.when(planetRepository.findByNameIgnoreCase("Mars")).thenReturn(planet);

        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(planet);

        Mockito.when(planetService.getPlanets()).thenReturn(planets);
        //Mockito.when(planetService.savePlanet(planet)).thenReturn(planet);
    }

    @Test
    void testGetPlanetByName() {
        String name = "Mars";
        Planet found = planetService.getPlanetByName(name);

        assertEquals(name, found.getName());
    }

    
    @Test
    void testGetPlanets() {
        List<Planet> planets = planetService.getPlanets();
        assertEquals(1, planets.size());
    }

    /* 
    @Test
    void testSavePlanet() {
    }
    */
    
}
