CREATE TABLE IF NOT EXISTS Loan (
    loan_id INT PRIMARY KEY AUTO_INCREMENT,
    loan_amount DECIMAL(10, 2) NOT NULL,
    term INT NOT NULL,
    loan_type VARCHAR(25) NOT NULL,
    interest_rate DECIMAL(5, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    mobile_no BIGINT NOT NULL,
    loan_id INT,
    FOREIGN KEY (loan_id) REFERENCES Loan(loan_id)
);


INSERT INTO Loan (loan_amount, term, loan_type, interest_rate) VALUES (1200000, 15, 'HomeLoan', 13);
INSERT INTO Loan (loan_amount, term, loan_type, interest_rate) VALUES (700000, 5, 'CarLoan', 9);
INSERT INTO Loan (loan_amount, term, loan_type, interest_rate) VALUES (900000, 5, 'CarLoan', 9);
INSERT INTO Loan (loan_amount, term, loan_type, interest_rate) VALUES (1500000, 15, 'HomeLoan', 13);
INSERT INTO Loan (loan_amount, term, loan_type, interest_rate) VALUES (2200000, 10, 'HomeLoan', 9);

INSERT INTO Customer (name, mobile_no, loan_id) VALUES ('Markel', 8765432112, 1);
INSERT INTO Customer (name, mobile_no, loan_id) VALUES ('Chris', 9665432112, 2);
INSERT INTO Customer (name, mobile_no, loan_id) VALUES ('James', 8765292112, NULL);
INSERT INTO Customer (name, mobile_no, loan_id) VALUES ('Alex', 8790432112, NULL);
INSERT INTO Customer (name, mobile_no, loan_id) VALUES ('Bernard', 7965432112, 4);
INSERT INTO Customer (name, mobile_no, loan_id) VALUES ('Michel', 8965432112, 5);