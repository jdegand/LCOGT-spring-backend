package com.example.LCOGTspringbackend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.LCOGTspringbackend.entity.Planet;

@DataJpaTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Planet planet = Planet.builder()
        .name("Earth")
        .size(new BigDecimal(1))
        .distance(new BigDecimal(1))
        .description("3rd rock from the sun.")
        .build();

        entityManager.persist(planet);
    }

    @Test
    void testFindByNameIgnoreCase() {
        Planet planet = planetRepository.findByNameIgnoreCase("earth");
        assertEquals(planet.getName(), "Earth");
    }
}
