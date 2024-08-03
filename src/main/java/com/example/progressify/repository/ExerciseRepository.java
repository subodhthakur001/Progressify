package com.example.progressify.repository;

import com.example.progressify.entity.Exercise;
import com.example.progressify.entity.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise , Long> {
    List<Exercise> findByMuscleId(Long id);
    Exercise findByname(String name);
}
