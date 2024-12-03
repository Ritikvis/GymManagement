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


    public void AddnewGym(Gym gym) {
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


}
