CREATE TABLE Medication (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    function VARCHAR(255),
    dosage_weight FLOAT,

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    created_by INT,
    updated_by INT,
    deleted BOOLEAN NOT NULL DEFAULT 0,

    CONSTRAINT FK_Medication_CreatedBy FOREIGN KEY (created_by) REFERENCES User(id),
    CONSTRAINT FK_Medication_UpdatedBy FOREIGN KEY (updated_by) REFERENCES User(id)
);
