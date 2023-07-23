package com.example.LCOGTspringbackend.system;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.LCOGTspringbackend.entity.Planet;
import com.example.LCOGTspringbackend.repository.PlanetRepository;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private final PlanetRepository planetRepository;

    public DBDataInitializer(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Planet p1 = new Planet();
        p1.setName("Mars");
        p1.setSize(new BigDecimal("0.107"));
        p1.setDistance(new BigDecimal("1.41"));
        p1.setOrdinality(4);
        p1.setDescription("Mars is the dry and inhospitable 4th planet from the Sun. It is here that Matt Damon grew potatoes using his own poop.");
        this.planetRepository.save(p1);
    }

}