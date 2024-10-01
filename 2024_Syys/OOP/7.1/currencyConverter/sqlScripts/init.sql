
DROP DATABASE IF EXISTS currency;
CREATE DATABASE currency;
USE currency;

CREATE TABLE currencies (
    abbr VARCHAR(3) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    rate DECIMAL(20, 10) NOT NULL,
    PRIMARY KEY (abbr)
);

INSERT INTO currencies (abbr, name, rate)
VALUES
('EUR', 'Euro', 0.89),
('GBP', 'Pound Sterling', 0.75),
('JPY', 'Japanese Yen', 143.13),
('AUD', 'Australian Dollar', 1.45),
('CAD', 'Canadian Dollar', 1.34),
('CHF', 'Swiss Franc', 0.84),
('IRR', 'Iranian Rial', 42160.593),
('KES', 'Kenyan Shilling', 128.97879),
('SEK', 'Swedish Kronor', 10.274134),
('USD', 'US Dollar', 1)
ON DUPLICATE KEY UPDATE rate = VALUES(rate);


DROP USER IF EXISTS appuser;
CREATE USER appuser IDENTIFIED BY 'password';
/* currently need only select as new currencies aren't added
    add more privileges as need arise */
GRANT SELECT ON currency.* TO appuser;





/* localhost only versions for the user */
/* not using these because using podman and might be using external ip to access it */
/*
#DROP USER IF EXISTS 'appuser'@'localhost';
#CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
#GRANT SELECT ON currency.* TO 'appuser'@'localhost';
#GRANT SELECT, INSERT, UPDATE, DELETE ON currency.* TO 'appuser'@'localhost';
*/