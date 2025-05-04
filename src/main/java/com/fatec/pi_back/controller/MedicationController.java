package main.java.com.fatec.pi_back.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.pi_back.domain.Medication.Medication;
import com.fatec.pi_back.service.MedicationService;

/**
 * REST controller for managing Medication entities.
 * <p>
 * Provides endpoints to perform CRUD operations and soft delete on medications.
 * </p>
 * 
 * Base URL: {@code /medication}
 * 
 * @author 
 */
@RestController
@RequestMapping("/medication")
public class MedicationController {

    /**
     * Service layer used to handle business logic for Medication.
     */
    @Autowired
    private MedicationService service;

    /**
     * Retrieves a list of all medications.
     *
     * @return a ResponseEntity containing the list of all Medication objects
     */
    @GetMapping
    public ResponseEntity<List<Medication>> getAll() {
        return ResponseEntity.ok(service.getAllMedications());
    }

    /**
     * Retrieves a medication by its ID.
     *
     * @param id the ID of the medication to retrieve
     * @return a ResponseEntity containing the Medication if found, or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Medication> getById(@PathVariable Long id) {
        Optional<Medication> medication = service.getMedicationById(id);
        return medication.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates a new medication.
     *
     * @param medication the Medication object to be created
     * @return a ResponseEntity containing the created Medication
     */
    @PostMapping
    public ResponseEntity<Medication> create(@RequestBody Medication medication) {
        Medication saved = service.createMedication(medication);
        return ResponseEntity.ok(saved);
    }

    /**
     * Updates an existing medication by ID.
     *
     * @param id the ID of the medication to update
     * @param body the updated Medication data
     * @return a ResponseEntity with the updated Medication or 404 if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Medication> update(@PathVariable Long id, @RequestBody Medication body) {
        Optional<Medication> updated = service.updateMedication(id, body);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Performs a soft delete on a medication (logical deletion).
     *
     * @param id the ID of the medication to delete
     * @return 204 No Content if successful, or 404 if the medication was not found
     */
    @PutMapping("/delete/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        boolean deleted = service.deleteMedication(id);
        return deleted ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }
}
