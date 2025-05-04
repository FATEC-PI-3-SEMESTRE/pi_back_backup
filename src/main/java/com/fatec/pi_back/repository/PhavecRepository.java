package com.fatec.pi_back.repository;

import com.fatec.pi_back.domain.Phavec.Phavec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhavecRepository extends JpaRepository<Phavec, Integer> {
}
