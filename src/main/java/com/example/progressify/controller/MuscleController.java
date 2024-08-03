package com.example.progressify.controller;

import com.example.progressify.entity.Muscle;
import com.example.progressify.response.ApiResponse;
import com.example.progressify.service.MuscleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/muscle")
public class MuscleController {
    @Autowired
    private MuscleService muscleService;

    @PostMapping
    public ResponseEntity<ApiResponse> addMuscle(@Valid @RequestBody Muscle muscle){
        Muscle savedMuscle = muscleService.addMuscle(muscle);
        ApiResponse response = new ApiResponse("Muscle Saved Successfully",null,savedMuscle);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @PostMapping
//    public ResponseEntity<ApiResponse> updateMuscle(@RequestBody Muscle muscle){
//        Muscle updateMuscle = muscleService.updateMuscle(muscle);
//        ApiResponse response = new ApiResponse("Muscle Updated Successfully",null,updateMuscle);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @GetMapping
    public ResponseEntity<ApiResponse> muscleList(){
        List<Muscle> muscleList = muscleService.muscleList();
        ApiResponse response = new ApiResponse("Muscle Listing Fetched Successfully",null,muscleList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
