package com.example.progressify.repository;

import com.example.progressify.entity.Exercise_Workout;
import com.example.progressify.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Optional<Workout> findTopByUserIdAndMuscleIdOrderByCreatedAtDesc(Long userId, Long muscleId);
}
