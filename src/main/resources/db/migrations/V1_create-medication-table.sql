CREATE TABLE [Medication] (
    id INT AUTOINCREMENT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    function NVARCHAR(255),
    dosage_weight FLOAT,

    created_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    updated_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    created_by INT,
    updated_by INT,
    deleted BIT NOT NULL DEFAULT 0,

    CONSTRAINT FK_Medication_CreatedBy FOREIGN KEY (created_by) REFERENCES [User](id),
    CONSTRAINT FK_Medication_UpdatedBy FOREIGN KEY (updated_by) REFERENCES [User](id)
);
