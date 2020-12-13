
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS car_classes;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS role;

CREATE TABLE car_class (
	id SERIAL PRIMARY KEY,
	class VARCHAR(64) NOT NULL
);

CREATE TABLE invoice_status (
	id SERIAL PRIMARY KEY,
	status_name VARCHAR(64)
);

CREATE TABLE account_role (
	id SERIAL PRIMARY KEY,
	role_name VARCHAR(64)
);

CREATE TABLE account (
	id SERIAL PRIMARY KEY,
	login VARCHAR (64) UNIQUE,
	first_name VARCHAR (64),
	second_name VARCHAR (64),
	role_id INT,
	CONSTRAINT fk_account_role_id FOREIGN KEY (role_id)
	REFERENCES account_role (id) 
);

CREATE TABLE car (
	id SERIAL PRIMARY KEY,
	model VARCHAR(64) NOT NULL,
	car_class INT,
	rent_price FLOAT,
	avable BOOL DEFAULT true,
	CONSTRAINT ck_rent_price CHECK (rent_price >= 0),
	CONSTRAINT fk_car_car_class FOREIGN KEY (car_class)
	REFERENCES car_class (id)
	ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE invoice (
	id SERIAL PRIMARY KEY,
	client_id INT,
	car_id INT,
	total_cost FLOAT,
	driver BOOL DEFAULT false,
	days_rent INT,
	create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	rent_to_date TIMESTAMP,
	CONSTRAINT fk_invoice_car_id FOREIGN KEY (car_id) 		
	REFERENCES car (id)
	ON UPDATE CASCADE ON DELETE SET NULL,
	CONSTRAINT fk_invoice_client_id FOREIGN KEY (client_id) 	
	REFERENCES account (id)
	ON UPDATE CASCADE ON DELETE SET NULL
);