package main.java.com.fatec.pi_back.domain.RelationMP;

import java.util.UUID;

@Table(name = "relation_mp")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RelationMP {
    
    @Id
    @GeneratedValue
    private UUID id;

    private Integer dosage;
    
    @ManyToOne
    @JoinColumn(name = "fk_medication")
    private Event fkMedication;

    @ManyToOne
    @JoinColumn(name = "fk_patient")
    private Event fkPatient;

}
