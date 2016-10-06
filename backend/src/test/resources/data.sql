CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO examinations (id, exm_description, exm_name, exm_price) VALUES (uuid_generate_v4(), 'This test should be deleted', 'Test to delete', 30);
INSERT INTO examinations (id, exm_description, exm_name, exm_price) VALUES (uuid_generate_v4(), 'Name of test should be "Test updated"', 'Test to update', 31);
INSERT INTO examinations (id, exm_description, exm_name, exm_price) VALUES (uuid_generate_v4(), 'This test should be fetched', 'Static test', 32);