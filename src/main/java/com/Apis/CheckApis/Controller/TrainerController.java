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
    @PostMapping("saveTrainer")
    public ResponseEntity<Trainer> AddnewTrainer(@RequestBody Trainer trainer){
        trainerService.AddnewTrainer(trainer);
        return new ResponseEntity<>(trainer, HttpStatus.CREATED);
    }
    @GetMapping("more-than-five-gyms")
    public List<Trainer> getTrainersWithMoreThanFiveGyms() {
        return trainerService.findTrainersWithMoreThanFiveGyms();
    }
    @PostMapping("AddGymToTrainer")
    public ResponseEntity<Void> AddGymToTrainer(@RequestParam Long trainerId,@RequestParam Long gymId){
        trainerService.AddGymToTrainer(trainerId,gymId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("AddMemberToTrainer")
    public ResponseEntity<Void> AddMemberToTrainer(@RequestParam Long trainerId,@RequestParam Long memberId){
        trainerService.AddMemberToTrainer(trainerId,memberId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
