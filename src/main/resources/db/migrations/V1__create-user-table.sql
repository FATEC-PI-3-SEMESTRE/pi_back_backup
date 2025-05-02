CREATE TABLE [User] (
    id INT AUTOINCREMENT PRIMARY KEY,
    email NVARCHAR(255) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    access BIT NOT NULL DEFAULT 0,

    created_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    updated_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    created_by INT,
    updated_by INT,
    deleted BIT NOT NULL DEFAULT 0,

    CONSTRAINT FK_User_CreatedBy FOREIGN KEY (created_by) REFERENCES [User](id),
    CONSTRAINT FK_User_UpdatedBy FOREIGN KEY (updated_by) REFERENCES [User](id)
);
