create table `p_have_c`(
	id INT AUTO_INCREMENT NOT NULL,
	id_patient int not null,
	id_caregiver int not null,

	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by INT,
    updated_by INT,
    deleted TINYINT(1) NOT NULL DEFAULT 0,

    PRIMARY KEY(id),
    CONSTRAINT fk_created_by_p_have_c_user_id FOREIGN KEY (created_by) REFERENCES `user`(id),
    CONSTRAINT fk_updated_by_p_have_c_user_id FOREIGN KEY (updated_by) REFERENCES `user`(id),
    CONSTRAINT fk_id_patient_p_have_c_patient_id FOREIGN KEY (id_patient) REFERENCES `patient`(id),
    CONSTRAINT fk_id_caregiver_p_have_c_patient_id FOREIGN KEY (id_caregiver) REFERENCES `caregiver`(id)
)