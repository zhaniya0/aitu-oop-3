CREATE TABLE Candidate (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE Exam (
    examId INT PRIMARY KEY,
    subject VARCHAR(50),
    date DATE
);