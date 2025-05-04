package main.java.com.fatec.pi_back.domain.Medication;

import java.time.LocalDateTime;

import com.fatec.pi_back.domain.User.User;
import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a Medication entity in the system.
 * Stores information about a medicine including its name, function,
 * dosage weight, creation and update metadata.
 * 
 * This entity is mapped to the "medication" table in the database.
 * 
 * @author 
 */
@Entity
@Table(name = "medication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medication {

    /**
     * Unique identifier for each medication (auto-generated).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the medication. This field is mandatory.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Description of the medication's purpose or function.
     */
    @Column(length = 255)
    private String function;

    /**
     * Weight of the dosage (e.g., in mg or ml).
     */
    @Column(name = "dosage_weight")
    private Float dosageWeight;

    /**
     * Date and time when the medication record was created.
     * Automatically set when the entity is persisted.
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Date and time when the medication record was last updated.
     * Automatically updated on changes.
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * User who created this medication record.
     * Links to the User entity (foreign key).
     */
    @ManyToOne
    @JoinColumn(name = "created_by", updatable = false)
    private User createdBy;

    /**
     * User who last updated this medication record.
     * Links to the User entity (foreign key).
     */
    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    /**
     * Indicates whether the medication is logically deleted.
     * Used for soft deletion.
     */
    @Column(nullable = false)
    private boolean deleted = false;

    /**
     * Constructor used to create a Medication instance without audit fields.
     * 
     * @param name Name of the medication
     * @param function Purpose/function of the medication
     * @param dosageWeight Dosage weight (e.g., mg)
     */
    public Medication(String name, String function, Float dosageWeight) {
        this.name = name;
        this.function = function;
        this.dosageWeight = dosageWeight;
    }
}
