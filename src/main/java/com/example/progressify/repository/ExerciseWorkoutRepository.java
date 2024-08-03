package com.example.progressify.repository;

import com.example.progressify.entity.Exercise_Workout;
import com.example.progressify.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseWorkoutRepository extends JpaRepository<Exercise_Workout, Long> {

    List<Exercise_Workout> findByWorkout(Workout workout);
}
