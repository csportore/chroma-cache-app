INSERT INTO professionals(name, profession, last_updated) VALUES ('Professional1', 'NUTRITIONIST', CURRENT_TIMESTAMP);
INSERT INTO professionals(name, profession, last_updated) VALUES ('Professional3', 'NUTRITIONIST', CURRENT_TIMESTAMP);
INSERT INTO professionals(name, profession, last_updated) VALUES ('Professional2', 'DIETITIAN', CURRENT_TIMESTAMP);
INSERT INTO professionals(name, profession, last_updated) VALUES ('Professional4', 'DIETITIAN', CURRENT_TIMESTAMP);
INSERT INTO professionals(name, profession, last_updated) VALUES ('Professional5', 'NUTRITIONIST', CURRENT_TIMESTAMP);

INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient1', '12345678901', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient2', '12345678902', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient3', '12345678903', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient4', '12345678904', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient5', '12345678905', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient6', '12345678906', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient7', '12345678907', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient8', '12345678908', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient9', '12345678909', CURRENT_TIMESTAMP);
INSERT INTO patients(name, document_number, last_updated) VALUES ('Patient10', '12345678910', CURRENT_TIMESTAMP);

INSERT INTO professionals_patients(professional_id, patient_id) VALUES (1,1);
INSERT INTO professionals_patients(professional_id, patient_id) VALUES (1,2);
INSERT INTO professionals_patients(professional_id, patient_id) VALUES (2,3);
INSERT INTO professionals_patients(professional_id, patient_id) VALUES (3,4);

/*
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient1', 1, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient2', 2, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient3', 3, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient4', 4, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient5', 5, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient6', 1, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient7', 1, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient8', 2, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient9', 3, CURRENT_TIMESTAMP);
INSERT INTO patients(name, professional_id, last_updated) VALUES ('Patient10', 3, CURRENT_TIMESTAMP);
*/