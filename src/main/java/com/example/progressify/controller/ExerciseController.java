package com.example.progressify.controller;

import com.example.progressify.dto.ExerciseDTO;
import com.example.progressify.entity.Exercise;
import com.example.progressify.response.ApiResponse;
import com.example.progressify.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;


    @GetMapping("/muscle/{muscleId}")
    public ResponseEntity<ApiResponse> getExercisesByMuscleId(@PathVariable("muscleId") Long id){
        List<Exercise> exerciseListByMuscle = exerciseService.getExerciseByMuscleId(id);
        ApiResponse response = new ApiResponse("Exercise By muscle list",null,exerciseListByMuscle);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addExercise(@RequestBody ExerciseDTO exerciseDTO){
        Exercise savedExercise = exerciseService.addExercise(exerciseDTO);
        ApiResponse response = new ApiResponse("Exercise Saved",null,savedExercise);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}

