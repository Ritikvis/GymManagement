package com.Apis.CheckApis.Controller;

import com.Apis.CheckApis.Entity.Member;
import com.Apis.CheckApis.Entity.Trainer;
import com.Apis.CheckApis.Service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

//    http://localhost:8080/Trainer/saveTrainer
    @PostMapping("saveTrainer")
    public ResponseEntity<Trainer> AddnewTrainer(@RequestBody Trainer trainer){
        trainerService.AddnewTrainer(trainer);
        return new ResponseEntity<>(trainer, HttpStatus.CREATED);
    }
    @GetMapping("more-than-five-gyms")
    public List<Trainer> getTrainersWithMoreThanFiveGyms() {
        return trainerService.findTrainersWithMoreThanFiveGyms();
    }


}
