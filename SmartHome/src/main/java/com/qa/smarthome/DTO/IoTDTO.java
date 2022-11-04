package com.qa.smarthome.DTO;

import com.qa.smarthome.model.IoT;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class IoTDTO {

	public IoTDTO(IoT iot) {

	}

	private Long id;
	private String manufacturer; // Samsung SmartThings, GoogleHome, Amazon Echo, Apple Homekit.
	private String product; // light bulb, smart display, speakers, thermostat, etc.
	private Boolean compatible; // yes=true no=false

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Boolean getCompatible() {
		return compatible;
	}

	public void setCompatible(Boolean compatible) {
		this.compatible = compatible;
	}

}
