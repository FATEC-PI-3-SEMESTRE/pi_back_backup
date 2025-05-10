package main.java.com.fatec.pi_back.domain.Medication;

import com.fatec.pi_back.domain.User.User;

/**
 * Data Transfer Object (DTO) for Medication entity.
 * Used to carry data between processes in a simplified structure.
 * 
 * @param name name of the medication
 * @param function function or purpose of the medication
 * @param dosageWeight weight of the dosage (e.g., mg)
 * @param updatedBy user who updated the medication
 */
public record MedicationDTO(
    String name,
    String function,
    Float dosageWeight,
    User updatedBy
) {
}