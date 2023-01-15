INSERT INTO INSURANCE_TYPE VALUES
(1, 'Haftpflicht'),
(2, 'Teilkasko'),
(3, 'Vollkasko');

INSERT INTO REGISTRATION_PLATE VALUES
(4, 'GM QF 320'),
(5, 'GM MM 423'),
(6, 'GM AB 197');

INSERT INTO VEHICLE(ID, MARKE, MODELL, BAUJAHR) VALUES
(100, 'BMW', '320d', '2011'),
(101, 'VW', 'Passat', '2020'),
(102, 'Ford', 'Fiesta', '2014');

INSERT INTO CUSTOMER(ID, HAUSNR, NACHNAME, ORT, PLZ, STRASSE, VORNAME, VEHICLE_ID, REGISTRATION_PLATE_ID, INSURANCE_TYPE_ID) VALUES
(1000, '21', 'Breit', 'Nümbrecht', '51588', 'Krahm', 'Florian', 100, 4, 1),
(1001, '2', 'Mustermann', 'Musterstadt', '12895', 'Musterstraße', 'Max', 101, 5, 2);