DROP TABLE IF EXISTS iot CASCADE;
CREATE TABLE iot 
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	app_required BOOLEAN,
	compatible_with_third_party BOOLEAN,
	description VARCHAR(255),
	generation VARCHAR (255),
	hub_required BOOLEAN,
	matter_ready BOOLEAN,
	manufacturer VARCHAR(255),
	model_number VARCHAR(255),
	product_name VARCHAR(255),
	protocol VARCHAR(255)
);