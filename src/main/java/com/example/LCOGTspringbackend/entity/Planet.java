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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long planetId;

    @Column(unique = true)
    @Length(max=8, min=3)
    private String name;

    @Digits(integer = 3, fraction = 4)
    private BigDecimal size;
    
    @Digits(integer = 2, fraction = 3)
    private BigDecimal distance;
    
    @Min(1)
    @Max(8)
    private Integer ordinality;
    
    @Length(max = 400)
    private String description;

    
}
