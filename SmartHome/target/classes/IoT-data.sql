INSERT INTO iot
(
	id,
	app_required,
	compatible_with_third_party,
	description,
	generation,
	hub_required,
	matter_ready,
	manufacturer,
	model_number,
	product_name,
	protocol
)
VALUES
(
	DEFAULT,
	TRUE,
	TRUE,
	'smart plug outlet',
	'2019',
	TRUE,
	TRUE,
	'Samsung',
	'GP-WOU019BBDWG',
	'Smart Home Plug',
	'zigbee'
),
(
	DEFAULT,
	TRUE,
	TRUE,
	'smart speaker',
	'4th',
	FALSE,
	TRUE,
	'Amazon',
	'B7W64E',
	'Echo Dot',
	'wifi'
);