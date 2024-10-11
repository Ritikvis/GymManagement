package com.Apis.CheckApis.Repository;

import com.Apis.CheckApis.Entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRopository extends JpaRepository<Gym,Long> {
}
