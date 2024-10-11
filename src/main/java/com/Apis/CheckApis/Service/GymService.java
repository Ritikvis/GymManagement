package com.Apis.CheckApis.Service;

import com.Apis.CheckApis.Entity.Gym;
import com.Apis.CheckApis.Entity.Member;
import com.Apis.CheckApis.Entity.Trainer;
import com.Apis.CheckApis.Repository.GymRopository;
import com.Apis.CheckApis.Repository.MemberRepository;
import com.Apis.CheckApis.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class GymService {
    @Autowired
    private GymRopository gymRopository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    public void AddnewGym(Gym gym) {
        gymRopository.save(gym);
    }

    public void AddMemberToGym(Long gymId, Long memberId) {
        Gym gym = gymRopository.findById(gymId)
                .orElseThrow(()->new RuntimeException("Id not found: " + gymId));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("Id not found : " + memberId));
        List<Member> memberList = gym.getMembers();
        memberList.add(member);
        memberRepository.save(member);
        gymRopository.save(gym);
    }


    public int findNumberOfMembersInGym(Long gymId) {
        Gym gym = gymRopository.findById(gymId).orElse(null);
        if (gym != null) {
            return gym.getMembers().size();
        }
        return 0;
    }

    public Gym findGymWithMostMembers() {

        List<Gym> gyms = gymRopository.findAll();
        Gym gymWithMostMembers = null;
        int maxMembers = 0;

        for (Gym gym : gyms) {
            int memberCount = gym.getMembers().size();
            if (memberCount > maxMembers) {
                maxMembers = memberCount;
                gymWithMostMembers = gym;
            }
        }

        return gymWithMostMembers;
    }

    public Gym getGym(Long gymId) {
        return gymRopository.findById(gymId)
                .orElseThrow(()->new RuntimeException("id not found: " + gymId));
    }

    public void AddTrainerToGym(Long gymId, Long trainerId) {
        Gym gym = gymRopository.findById(gymId)
                .orElseThrow(()->new RuntimeException("ID not found: " + gymId));
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(()->new RuntimeException("Id not found : " +  trainerId));
        List<Trainer> trainers = gym.getTrainers();
        trainers.add(trainer);
        trainerRepository.save(trainer);
        gymRopository.save(gym);
    }
}
