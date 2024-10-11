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

    public void AddnewMember(Member member) {
        memberRepository.save(member);
    }

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

    public void AddGymToMember(Long memberId, Long gymId) {
        Gym gym = gymRopository.findById(gymId)
                .orElseThrow(()->new RuntimeException("Id not found: " + gymId));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("Id not found : " + memberId));
        member.setGym(gym);
        memberRepository.save(member);
        gymRopository.save(gym);
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("Nont found: " + memberId));
    }

    public void AddTrainerToMember(Long memberId, Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(()->new RuntimeException("Id not found: " + trainerId));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()->new RuntimeException("Id not found : " + memberId));
        member.setTrainer(trainer);
        memberRepository.save(member);
        trainerRepository.save(trainer);
    }

}
