CREATE TABLE `relations_mp` (
    id INT AUTO_INCREMENT NOT NULL,
    dosage INT NOT NULL,
    fk_medication INT NOT NULL,
    fk_patient INT NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by INT,
    updated_by INT,
    deleted TINYINT(1) NOT NULL DEFAULT 0,

    PRIMARY KEY(id),
    CONSTRAINT fk_created_by_relations_mp_user_id FOREIGN KEY (created_by) REFERENCES `user`(id),
    CONSTRAINT fk_updated_by_relations_mp_user_id FOREIGN KEY (updated_by) REFERENCES `user`(id)
    CONSTRAINT fk_medication_relations_mp_medication_id FOREIGN KEY (fk_medication) REFERENCES `medication`(id),
    CONSTRAINT fk_patient_relations_mp_patient_id FOREIGN KEY (fk_patient) REFERENCES `patient`(id)
);