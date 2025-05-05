package main.java.com.fatec.pi_back.domain.TimeInterval;

import java.util.UUID;

import jakarta.persistence.Table;

@Table(name = "time_interval")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimeInterval {

    @Id
    @GeneratedValue
    private UUID id;

    private Float interval;
}
