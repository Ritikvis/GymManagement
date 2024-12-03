package com.Apis.CheckApis.Service;

import com.Apis.CheckApis.Entity.Gym;
import com.Apis.CheckApis.Entity.Member;
import com.Apis.CheckApis.Entity.Trainer;
import com.Apis.CheckApis.Repository.GymRopository;
import com.Apis.CheckApis.Repository.MemberRepository;
import com.Apis.CheckApis.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public void AddnewTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    public List<Trainer> findTrainersWithMoreThanFiveGyms() {
        List<Trainer> allTrainers = trainerRepository.findAll();
        List<Trainer> trainersWithMoreThanFiveGyms = new ArrayList<>();

        for (Trainer trainer : allTrainers) {
            if (trainer.getGyms().size() > 5) {
                trainersWithMoreThanFiveGyms.add(trainer);
            }
        }

        return trainersWithMoreThanFiveGyms;
    }

}
