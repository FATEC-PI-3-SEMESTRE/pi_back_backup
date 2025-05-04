package main.java.com.fatec.pi_back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.pi_back.domain.Medication.Medication;
import com.fatec.pi_back.repository.MedicationRepository;

/**
 * Service layer for managing Medication entities.
 * <p>
 * This class contains business logic related to the Medication entity
 * and acts as a bridge between the controller and the repository.
 * </p>
 * 
 * @author 
 */
@Service
public class MedicationService {

    /**
     * Repository for accessing Medication data from the database.
     */
    @Autowired
    private MedicationRepository repository;

    /**
     * Retrieves all medications from the database.
     * 
     * @return a list of all Medication entities
     */
    public List<Medication> getAllMedications() {
        return repository.findAll();
    }

    /**
     * Retrieves a specific medication by its ID.
     * 
     * @param id the ID of the medication to retrieve
     * @return an Optional containing the Medication, if found
     */
    public Optional<Medication> getMedicationById(Long id) {
        return repository.findById(id);
    }

    /**
     * Saves a new Medication to the database.
     * 
     * @param medication the Medication object to be saved
     * @return the saved Medication entity
     */
    public Medication createMedication(Medication medication) {
        return repository.save(medication);
    }

    /**
     * Updates an existing Medication with new data.
     * 
     * @param id the ID of the Medication to update
     * @param updatedData the new Medication data
     * @return an Optional containing the updated Medication, if found and modified
     */
    public Optional<Medication> updateMedication(Long id, Medication updatedData) {
        return repository.findById(id).map(existing -> {
            existing.setName(updatedData.getName());
            existing.setFunction(updatedData.getFunction());
            existing.setDosageWeight(updatedData.getDosageWeight());
            existing.setUpdatedBy(updatedData.getUpdatedBy());
            return repository.save(existing);
        });
    }

    /**
     * Performs a soft delete on a Medication by setting its deleted flag.
     * 
     * @param id the ID of the Medication to delete
     * @return true if the medication was found and marked as deleted, false otherwise
     */
    public boolean deleteMedication(Long id) {
        return repository.findById(id).map(medication -> {
            medication.setDeleted(true); // Soft delete
            repository.save(medication);
            return true;
        }).orElse(false);
    }
}
