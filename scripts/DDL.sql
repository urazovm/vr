CREATE TABLE accounts
(
  acc_id UUID PRIMARY KEY NOT NULL,
  acc_creation_date DATE NOT NULL,
  acc_role SMALLINT NOT NULL DEFAULT 0,
  acc_state SMALLINT NOT NULL DEFAULT 0,
  acc_name VARCHAR(100),
  acc_surname VARCHAR(100),
  acc_legal BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE UNIQUE INDEX accounts_acc_id_uindex ON accounts (acc_id);
CREATE UNIQUE INDEX accounts_acc_legal_uindex ON accounts (acc_legal);

CREATE TABLE users
(
  usr_id UUID PRIMARY KEY NOT NULL,
  usr_login VARCHAR(256) NOT NULL,
  usr_password VARCHAR(100) NOT NULL,
  usr_acc_id UUID NOT NULL REFERENCES accounts (acc_id),
  usr_creation_date DATE NOT NULL
);
CREATE UNIQUE INDEX users_usr_id_uindex ON users (usr_id);
CREATE UNIQUE INDEX users_usr_login_uindex ON users (usr_login);

CREATE TABLE examinations
(
  exm_id UUID PRIMARY KEY NOT NULL,
  exm_name VARCHAR(256) NOT NULL,
  exm_description VARCHAR(4096),
  exm_price DECIMAL NOT NULL
);
CREATE UNIQUE INDEX examinations_exm_id_uindex ON examinations (exm_id);
CREATE UNIQUE INDEX examinations_exm_name_uindex ON examinations (exm_name);

CREATE TABLE questions
(
  qss_id UUID PRIMARY KEY NOT NULL,
  qss_exm_id UUID NOT NULL REFERENCES examinations (exm_id),
  qss_question VARCHAR(2048) NOT NULL,
  qss_description VARCHAR(4096),
  qss_weight DECIMAL,
  qss_type SMALLINT NOT NULL DEFAULT 0
);
CREATE UNIQUE INDEX questions_qss_id_uindex ON questions (qss_id);
CREATE UNIQUE INDEX questions_qss_exm_id_uindex ON questions (qss_exm_id);

CREATE TABLE options
(
  opt_id UUID PRIMARY KEY NOT NULL,
  opt_qss_id UUID NOT NULL REFERENCES questions (qss_id),
  opt_option VARCHAR(1024) NOT NULL,
  opt_right BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE UNIQUE INDEX options_opt_id_uindex ON options (opt_id);
CREATE UNIQUE INDEX options_opt_qss_id_uindex ON options (opt_qss_id);
CREATE UNIQUE INDEX options_opt_right_uindex ON options (opt_right);

CREATE TABLE account_examinations
(
  aex_id UUID PRIMARY KEY NOT NULL,
  aex_acc_id UUID NOT NULL REFERENCES accounts (acc_id),
  aex_exm_id UUID NOT NULL REFERENCES examinations (exm_id),
  aex_payed BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE UNIQUE INDEX account_examinations_aqz_id_uindex ON account_examinations (aex_id);

CREATE TABLE examination_results
(
  exr_id UUID PRIMARY KEY NOT NULL,
  exr_aqz_id UUID NOT NULL REFERENCES  account_examinations (aex_id),
  exr_start_time TIMESTAMP,
  exr_attempt INTEGER NOT NULL DEFAULT 0,
  exr_completed BOOLEAN NOT NULL DEFAULT FALSE

);
CREATE UNIQUE INDEX examination_results_exr_id_uindex ON examination_results (exr_id);

CREATE TABLE examination_options
(
  exa_id UUID PRIMARY KEY NOT NULL,
  exa_exr_id UUID NOT NULL REFERENCES examination_results (exr_id),
  exa_opt_id UUID NOT NULL REFERENCES options (opt_id),
  exa_answered BOOLEAN NOT NULL DEFAULT FALSE
);
CREATE UNIQUE INDEX examination_options_exa_id_uindex ON examination_options (exa_id);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO examinations (exm_name, exm_description, exm_price) VALUES ('Тест 1', 'Здесь будет описание теста', 1300)

INSERT INTO questions (id, exm_id, qss_question, qss_description, qss_weight, qss_type) VALUES (uuid,cast('214b6a8a-ae35-49d9-bc26-71ca53a7bde3' as UUID),	'Вопрос 3',	'Это третий вопрос',	1.3,	0)