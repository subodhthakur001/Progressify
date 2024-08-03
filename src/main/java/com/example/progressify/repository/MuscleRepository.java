package com.example.progressify.repository;

import com.example.progressify.entity.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleRepository extends JpaRepository<Muscle, Long> {
    Muscle findByname(String name);
}
