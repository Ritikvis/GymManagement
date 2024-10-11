package com.Apis.CheckApis.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gymId;
    private String gymName;
    @OneToMany(mappedBy = "gym",cascade = CascadeType.ALL)

    private List<Member> members;
    @ManyToMany

    @JoinTable(name = "gym_trainer",
            joinColumns = @JoinColumn(name = "gym_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id")
    )
    private List<Trainer> trainers;
    private Gym (){}

    public Gym(Long gymId, String gymName, List<Member> members, List<Trainer> trainers) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.members = members;
        this.trainers = trainers;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}
