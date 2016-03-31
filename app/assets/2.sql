CREATE TABLE RemoteTask (
ID SERIAL PRIMARY KEY,
URL VARCHAR(2000) NOT NULL,
Created TIMESTAMP,
Resolved TIMESTAMP,
IsResolved BOOLEAN,
ClientSecret VARCHAR(256) REFERENCES Secrets(ClientSecret)
);

INSERT INTO RemoteTask(URL,Created,ClientSecret) VALUES ('https://www.apache.org/', NOW(), 'test-1234');
INSERT INTO RemoteTask(URL,Created,ClientSecret) VALUES ('https://www.google.com/', NOW(), 'test-1234');
