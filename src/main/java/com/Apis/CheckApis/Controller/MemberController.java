package com.Apis.CheckApis.Controller;

import com.Apis.CheckApis.Entity.Gym;
import com.Apis.CheckApis.Entity.Member;
import com.Apis.CheckApis.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("AddGymToMember")
    public ResponseEntity<Void> AddGymToMember(@RequestParam Long memberId,@RequestParam Long gymId){
        memberService.AddGymToMember(memberId,gymId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("AddTrainerToMember")
    public ResponseEntity<Void> AddTrainerToMember(@RequestParam Long memberId,@RequestParam Long trainerId){
        memberService.AddTrainerToMember(memberId,trainerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("getMember/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId){
       Member member = memberService.getMember(memberId);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }

    @PostMapping("saveMember")
    public ResponseEntity<Member> AddnewMember(@RequestBody Member member){
        memberService.AddnewMember(member);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }
    @GetMapping("most-trainers")
    public Member getMemberWithMostTrainers() {
        return memberService.findMemberWithMostTrainers();
    }
    @GetMapping("one-trainer")
    public int getNumberOfMembersWithOneTrainer() {

        return memberService.countMembersWithOnlyOneTrainer();
    }
}
