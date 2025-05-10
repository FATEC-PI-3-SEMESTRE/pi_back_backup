package main.java.com.fatec.pi_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.pi_back.domain.Medication.Medication;

/**
 * Repository interface for Medication entity.
 * Provides basic CRUD operations and allows for custom query definitions
 * using Spring Data JPA.
 * 
 * @author Pedro Silva Faria dos Santos
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    /**
     * You can define custom query methods here,
     * for example:
     * List&lt;Medication&gt; findByNameContaining(String name);
     */

}
