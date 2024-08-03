package com.example.progressify.service;

import com.example.progressify.dto.ExerciseDTO;
import com.example.progressify.entity.Exercise;
import com.example.progressify.entity.Muscle;
import com.example.progressify.exception.DuplicateEntityException;
import com.example.progressify.exception.ResourceNotFoundException;
import com.example.progressify.repository.ExerciseRepository;
import com.example.progressify.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private MuscleRepository muscleRepository;

    public List<Exercise> getExerciseByMuscleId(Long id){
        return exerciseRepository.findByMuscleId(id);
    }

    public Exercise addExercise(ExerciseDTO exerciseDTO){

        if(exerciseRepository.findByname(exerciseDTO.getName()) != null){
            throw new DuplicateEntityException("exercise already exists with the name" + exerciseDTO.getName());
        }

        Muscle muscle = muscleRepository.findById(exerciseDTO.getMuscleId())
                .orElseThrow(() -> new ResourceNotFoundException("Muscle not found with id: " + exerciseDTO.getMuscleId()));


        Exercise exercise = new Exercise();
        exercise.setName(exerciseDTO.getName());
        exercise.setMuscle(muscle);

        return exerciseRepository.save(exercise);
    }





}
