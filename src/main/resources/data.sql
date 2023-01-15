INSERT INTO INSURANCE_TYPE VALUES
(1, 'Haftpflicht'),
(2, 'Teilkasko'),
(3, 'Vollkasko');

INSERT INTO REGISTRATION_PLATE VALUES
(4, 'GM QF 320'),
(5, 'GM MM 97'),
(6, 'GM HG 098'),
(7, 'GM KJ 68'),
(8, 'GM BN 577'),
(9, 'GM IO 345'),
(10, 'GM JM 1'),
(11, 'GM BB 987'),
(12, 'GM QF 320'),
(13, 'GM NI 423'),
(14, 'K JM 1'),
(15, 'K BB 987'),
(16, 'K HF 320'),
(17, 'K KL 423'),
(18, 'K QF 320'),
(19, 'K NM 423'),
(20, 'K ZG 197');

INSERT INTO VEHICLE(ID, MARKE, MODELL, BAUJAHR) VALUES
(100, 'BMW', '320d', '2011'),
(101, 'VW', 'Passat', '2020'),
(102, 'Ford', 'Fiesta', '2014');

INSERT INTO CUSTOMER(ID, VORNAME, NACHNAME, STRASSE, HAUSNR, PLZ, ORT, VEHICLE_ID, REGISTRATION_PLATE_ID, INSURANCE_TYPE_ID) VALUES
(1000, 'Florian', 'Breit', 'Krahm', '21', '51588', 'Nümbrecht', 100, 4, 2),
(1001, 'Max', 'Mustermann', 'Musterstraße', '1', '12345', 'Musterstadt', 101, 5, 1);