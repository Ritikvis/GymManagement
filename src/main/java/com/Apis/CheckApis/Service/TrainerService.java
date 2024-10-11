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
    @Autowired
    private GymRopository gymRopository;
    @Autowired
    private MemberRepository memberRepository;
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

    public void AddGymToTrainer(Long trainerId, Long gymId) {
        Trainer trainer = trainerRepository.findById(trainerId).
                orElseThrow(()->new RuntimeException("Id not found: "+  trainerId));
        Gym gym  = gymRopository.findById(gymId)
                .orElseThrow(()->new RuntimeException("Id not found: "+  gymId));
        List<Gym> gyms = trainer.getGyms();
        gyms.add(gym);
        gymRopository.save(gym);
        trainerRepository.save(trainer);
    }

    public void AddMemberToTrainer(Long trainerId, Long memberId) {
        Trainer trainer = trainerRepository.findById(trainerId).
                orElseThrow(()->new RuntimeException("Id not found: "+  trainerId));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("Id not found : " + memberId));
        List<Member> members = trainer.getMembers();
        members.add(member);
        memberRepository.save(member);
        trainerRepository.save(trainer);
    }
}
