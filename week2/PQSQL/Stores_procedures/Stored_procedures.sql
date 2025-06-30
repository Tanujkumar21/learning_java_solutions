CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    account_type VARCHAR(20),
    balance DECIMAL(10,2)
);

INSERT INTO accounts (account_id, account_type, balance) VALUES
(101, 'savings', 1000.00),
(102, 'savings', 1500.00),
(103, 'current', 2000.00),
(104, 'savings', 2500.00);

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(50),
    department_id INT,
    salary DECIMAL(10,2)
);

INSERT INTO employees (employee_id, name, department_id, salary) VALUES
(1, 'Alice', 10, 30000.00),
(2, 'Bob', 10, 35000.00),
(3, 'Charlie', 20, 28000.00),
(4, 'David', 20, 40000.00);

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'savings';
END;

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_id INT,
    IN bonus_percent DECIMAL(5,2)
)
BEGIN
    UPDATE employees
    SET salary = salary + (salary * bonus_percent / 100)
    WHERE department_id = dept_id;
END;

CREATE PROCEDURE TransferFunds(
    IN from_account INT,
    IN to_account INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE current_balance DECIMAL(10,2);

    SELECT balance INTO current_balance
    FROM accounts
    WHERE account_id = from_account;

    IF current_balance >= amount THEN
        UPDATE accounts
        SET balance = balance - amount
        WHERE account_id = from_account;

        UPDATE accounts
        SET balance = balance + amount
        WHERE account_id = to_account;
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds';
    END IF;
END;

CALL ProcessMonthlyInterest();

SELECT * FROM accounts;