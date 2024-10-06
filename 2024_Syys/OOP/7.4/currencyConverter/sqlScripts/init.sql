
DROP DATABASE IF EXISTS converter;
CREATE DATABASE converter;
USE converter;

DROP USER IF EXISTS appuser;
CREATE USER appuser IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE ON converter.* TO appuser;
GRANT CREATE, DROP ON converter.* TO appuser;


/*
CREATE TABLE currency (
    abbr VARCHAR(3) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    rate DECIMAL(20, 10) NOT NULL,
    PRIMARY KEY (abbr)
);

INSERT INTO currency (abbr, name, rate)
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
*/






/* localhost only versions for the user */
/* not using these because using podman and might be using external ip to access it */
/*
#DROP USER IF EXISTS 'appuser'@'localhost';
#CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
#GRANT SELECT ON converter.* TO 'appuser'@'localhost';
#GRANT SELECT, INSERT, UPDATE, DELETE ON converter.* TO 'appuser'@'localhost';
*/