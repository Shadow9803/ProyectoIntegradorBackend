package com.example.magiaepigia.repositories;

import com.example.magiaepigia.models.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Long> {
}