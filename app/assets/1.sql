CREATE TABLE Secrets (
ClientSecret VARCHAR(256) UNIQUE NOT NULL,
Description VARCHAR(1000) NOT NULL
);

INSERT INTO Secrets VALUES('test-1234', 'Test description for a test secret');
