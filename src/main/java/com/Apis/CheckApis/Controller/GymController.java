package com.Apis.CheckApis.Controller;

import com.Apis.CheckApis.Entity.Gym;
import com.Apis.CheckApis.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Gym")
public class GymController {
    @Autowired
    private GymService gymService;


//    http://localhost:8080/Gym/saveGym
    @PostMapping("saveGym")
    public ResponseEntity<Gym> AddnewGym(@RequestBody Gym gym){
        gymService.AddnewGym(gym);
        return new ResponseEntity<>(gym, HttpStatus.CREATED);
    }
    @GetMapping("getGym/{gymId}")
    public ResponseEntity<Gym> getGym(@PathVariable Long gymId){
        Gym gym = gymService.getGym(gymId);
        return new ResponseEntity<>(gym,HttpStatus.OK);
    }
    @GetMapping("findNumberOfMembersInGym/{gymId}")
    public int getNumberOfMembersInGym(@PathVariable Long gymId) {
        return gymService.findNumberOfMembersInGym(gymId);
    }
    @GetMapping("max-members")
    public Gym getGymWithMostMembers() {
        return gymService.findGymWithMostMembers();
    }

}
