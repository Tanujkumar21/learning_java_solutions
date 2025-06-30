CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    dob DATE
);

CREATE TABLE loans (
    loan_id INT PRIMARY KEY,
    customer_id INT,
    interest_rate DECIMAL(5,2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO customers VALUES 
(1, 'John Smith', '1950-04-15'),
(2, 'Mary Johnson', '1980-08-25'),
(3, 'Robert Lee', '1945-11-10');

INSERT INTO loans VALUES 
(101, 1, 7.50),
(102, 2, 6.75),
(103, 3, 8.00);

CREATE PROCEDURE ApplySeniorDiscount()
BEGIN
    DECLARE cust_id INT;
    DECLARE cust_dob DATE;
    DECLARE done INT DEFAULT FALSE;

    DECLARE cust_cursor CURSOR FOR
        SELECT CUSTOMER_ID, DOB FROM CUSTOMERS;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cust_cursor;

    read_loop: LOOP
        FETCH cust_cursor INTO cust_id, cust_dob;
        IF done THEN
            LEAVE read_loop;
        END IF;

        IF TIMESTAMPDIFF(YEAR, cust_dob, CURDATE()) > 60 THEN
            UPDATE LOANS
            SET INTEREST_RATE = INTEREST_RATE - 1.00
            WHERE CUSTOMER_ID = cust_id;
        END IF;
    END LOOP;

    CLOSE cust_cursor;
END;

CALL ApplySeniorDiscount();

SELECT * FROM LOANS;