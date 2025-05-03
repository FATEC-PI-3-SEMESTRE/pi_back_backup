CREATE TABLE [RelationsMP] (
    id INT AUTOINCREMENT PRIMARY KEY,
    dosage INT NOT NULL,
    FK_Medication INT NOT NULL,
    FK_Patient INT NOT NULL,

    created_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    updated_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    created_by INT,
    updated_by INT,
    deleted BIT NOT NULL DEFAULT 0,

    CONSTRAINT FK_User_CreatedBy FOREIGN KEY (created_by) REFERENCES [User](id),
    CONSTRAINT FK_User_UpdatedBy FOREIGN KEY (updated_by) REFERENCES [User](id)
    CONSTRAINT FK_RelationsMP_Medication FOREIGN KEY (FK_Medication) REFERENCES [Medication](id),
    CONSTRAINT FK_RelationsMP_Patient FOREIGN KEY (FK_Patient) REFERENCES [Patient](id)
);