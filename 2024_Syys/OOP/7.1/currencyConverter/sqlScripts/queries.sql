/* test queries as per assignment */
SELECT * FROM currencies;
SELECT * FROM currencies WHERE (abbr LIKE 'EUR');
SELECT COUNT(*) FROM currencies;
SELECT MAX(rate) FROM currencies;