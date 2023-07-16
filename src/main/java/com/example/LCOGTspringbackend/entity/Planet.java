package com.example.LCOGTspringbackend.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // planetId originally - conflict in frontend interface and previously defined as id in express backend

    @Column(unique = true)
    @Length(max=8, min=3)
    private String name;
    
    // @Pattern(regexp = "^\\d{0,3}\\.\\d{1,4}$")

    @Digits(integer = 3, fraction = 4)
    private BigDecimal size;
    
    @Digits(integer = 2, fraction = 3)
    private BigDecimal distance;
    
    @Min(1)
    @Max(8)
    private Integer ordinality;
    
    @Length(max = 400)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getOrdinality() {
        return ordinality;
    }

    public void setOrdinality(Integer ordinality) {
        this.ordinality = ordinality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Planet(Long id, String name, BigDecimal size, BigDecimal distance, Integer ordinality, String description) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.distance = distance;
        this.ordinality = ordinality;
        this.description = description;
    }

    public Planet (){}

    @Override
    public String toString() {
        return "Planet [id=" + id + ", name=" + name + ", size=" + size + ", distance=" + distance
                + ", ordinality=" + ordinality + ", description=" + description + "]";
    }

    
}
