package com.fatec.pi_back.repository;

import com.fatec.pi_back.domain.Caregiver.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {
}
