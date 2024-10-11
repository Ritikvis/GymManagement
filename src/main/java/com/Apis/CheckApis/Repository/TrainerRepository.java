package com.Apis.CheckApis.Repository;

import com.Apis.CheckApis.Entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {
}
