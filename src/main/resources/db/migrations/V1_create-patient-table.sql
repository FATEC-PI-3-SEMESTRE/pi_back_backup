CREATE TABLE [Patient] (
    id INT AUTOINCREMENT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    age int NOT NULL,
    condition NVARCHAR(20)
    self_care BIT NOT NULL DEFAULT 0,

    created_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    created_by INT,
    updated_at DATETIME2 DEFAULT GETDATE() NOT NULL,
    updated_by INT,
    deleted BIT NOT NULL DEFAULT 0,
);