package com.example.progressify.controller;

import com.example.progressify.dto.PreviousWorkoutDto;
import com.example.progressify.dto.WorkoutExerciseDTO;
import com.example.progressify.dto.WorkoutResponseDTO;
import com.example.progressify.entity.Exercise_Workout;
import com.example.progressify.response.ApiResponse;
import com.example.progressify.service.WorkoutExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/workout")
public class WorkoutController {

    @Autowired
    private WorkoutExerciseService workoutExerciseService;

    @PostMapping
    public ResponseEntity<ApiResponse> addWorkout(@RequestBody WorkoutExerciseDTO workoutExerciseDTODTO){
        WorkoutResponseDTO workoutResponseDTO = workoutExerciseService.addWorkout(workoutExerciseDTODTO);
        ApiResponse response = new ApiResponse("workout saved Successfully", null ,workoutResponseDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/previous-workout/{user_id}")
    public ResponseEntity<ApiResponse> getPreviousWorkoutInfo(@RequestParam("userId") Long userId, @RequestParam("muscleId") Long muscleId){
        PreviousWorkoutDto previousWorkoutDto = workoutExerciseService.getPreviousWorkoutInfo(userId,muscleId);
        ApiResponse response = new ApiResponse("Previous workout fetched successfully !", null ,previousWorkoutDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
