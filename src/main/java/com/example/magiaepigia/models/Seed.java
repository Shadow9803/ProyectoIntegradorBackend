package com.example.magiaepigia.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "seeds")
public class Seed {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String name;

    //Parental
    @Column (nullable = false)
    private String parentalMother;
    @Column (nullable = false)
    private String parentalFather;

    // Seed Information
    @Column (nullable = false)
    private String seedType;
    @Column (nullable = false)
    private String seedOrigin;
    @Column (nullable = false)
    private String predominantCannabinoid;
    @Column (nullable = false)
    private float cannabinoidPercentage;
    @Column (nullable = false)
    private float germinationRate; // %

    //Batch Control
    @Column (nullable = false)
    private LocalDate seedBatchDate;
    @Column (nullable = false)
    private String batchCode;

    //Selection & Status
    @Column (nullable = false)
    private boolean selectStrain;
    @Column (nullable = false) //que es selecionar la cepa
    private String strainStatus;
}
