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

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private GymRopository gymRopository;
    @Autowired
    private TrainerRepository trainerRepository;



    public Member findMemberWithMostTrainers() {
        List<Member> members = memberRepository.findAll();
        Member memberWithMostTrainers = null;
        int maxTrainers = 0;

        for (Member member : members) {
            int trainerCount = member.getTrainer() != null ? 1 : 0;
            if (trainerCount > maxTrainers) {
                maxTrainers = trainerCount;
                memberWithMostTrainers = member;
            }
        }

        return memberWithMostTrainers;
    }




    public int countMembersWithOnlyOneTrainer() {
        List<Member> members = memberRepository.findAll();
        int count = 0;

        for (Member member : members) {
            if (member.getTrainer() !=null) {
                count++;
            }
        }

        return count;
    }





    public Member addMember(Member member, Long gymId, Long trainerId) {
        Gym gym = gymRopository.findById(gymId)
                .orElseThrow(()-> new RuntimeException("Id not found"+ gymId));
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(()-> new RuntimeException("Id not found"+ trainerId));
        member.setTrainer(trainer);
        member.setGym(gym);
        return  memberRepository.save(member);
    }

    public List<Member> getMember() {
        return memberRepository.findAll();
    }
}
