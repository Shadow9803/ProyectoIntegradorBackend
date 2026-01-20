package com.example.magiaepigia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.magiaepigia.models.Seed;
import com.example.magiaepigia.repositories.SeedRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeedService {

    private final SeedRepository seedRepository;

    public List<Seed> getAll() {
        return seedRepository.findAll();
    }
    
    public Optional<Seed> getById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be valid and greater than 0");
        }
        return seedRepository.findById(id);
    }

    public Seed save(Seed seed) {
        if (seed == null) {
            throw new IllegalArgumentException("Seed cannot be null");
        }
        return seedRepository.save(seed);
    }

    public Seed update(Long id, Seed seedDetails) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be valid and greater than 0");
        }
        if (seedDetails == null) {
            throw new IllegalArgumentException("Seed details cannot be null");
        }
        
        Seed existingSeed = seedRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Seed with ID " + id + " not found"));
        
        seedDetails.setId(id);
        return seedRepository.save(seedDetails);
    }

    public void delete(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be valid and greater than 0");
        }
        if (!seedRepository.existsById(id)) {
            throw new IllegalArgumentException("Seed with ID " + id + " does not exist");
        }
        seedRepository.deleteById(id);
    }
}
