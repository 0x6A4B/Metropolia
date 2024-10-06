/* test queries as per assignment */
SELECT * FROM currency;
SELECT * FROM currency WHERE (abbr LIKE 'EUR');
SELECT COUNT(*) FROM currency;
SELECT MAX(rate) FROM currency;