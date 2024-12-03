package com.Apis.CheckApis.Controller;

import com.Apis.CheckApis.Entity.Gym;
import com.Apis.CheckApis.Entity.Member;
import com.Apis.CheckApis.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Member")
public class MemberController {
    @Autowired
    private MemberService memberService;

//    http://localhost:8080/Member/saveMember?gymId=1&trainerId=1
    @PostMapping("saveMember")
    public ResponseEntity<Member> addMember(@RequestBody Member member,
                                            @RequestParam Long gymId ,@RequestParam Long trainerId){
        Member member1  = memberService.addMember(member,gymId,trainerId);
        return new ResponseEntity<>(member1,HttpStatus.CREATED);
    }

//    http://localhost:8080/Member/getMemberCount
    @GetMapping("/getMemberCount")
    public ResponseEntity<Integer> getMemberCount() {
        int count = memberService.getMember().size();
        return new ResponseEntity<>(count, HttpStatus.OK);
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
