package com.Apis.CheckApis.Entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainerId;
    private String trainerName;
    @ManyToMany(mappedBy = "trainers")
    private List<Gym> gyms;
    @OneToMany(mappedBy = "trainer")
    private List<Member> members;
    public  Trainer(){}

    public Trainer(Long trainerId, String trainerName, List<Gym> gyms, List<Member> members) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.gyms = gyms;
        this.members = members;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public List<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(List<Gym> gyms) {
        this.gyms = gyms;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
