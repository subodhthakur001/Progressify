package com.example.progressify.service;

import com.example.progressify.entity.Muscle;
import com.example.progressify.exception.DuplicateEntityException;
import com.example.progressify.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MuscleService {

    @Autowired
    private MuscleRepository muscleRepository;

    public Muscle addMuscle(Muscle muscle){
        if(muscleRepository.findByname(muscle.getName()) != null){
            throw new DuplicateEntityException("muscle already exists " + muscle.getName());
        }
        return muscleRepository.save(muscle);
    }

    public Muscle updateMuscle(Muscle muscle){
        Muscle musleToUpdate = muscleRepository.findById(muscle.getId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "muscle does not exists with id " + muscle.getId()));
        if(muscle.getName() != null){
            musleToUpdate.setName(muscle.getName());
        }
        return muscleRepository.save(musleToUpdate);
    }

    public List<Muscle> muscleList(){
        List<Muscle> muscles = muscleRepository.findAll();
      muscles.sort((Muscle a, Muscle b) -> a.getName().compareTo(b.getName()));
        return muscles;
    }
}
