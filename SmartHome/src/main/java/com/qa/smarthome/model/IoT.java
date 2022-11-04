package com.qa.smarthome.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class IoT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column
	public Boolean appRequired;

	@Column
	public Boolean compatibleWithThirdParty;

	@Column
	public String description;

	@Column
	public String generation;

	@Column
	public Boolean hubRequired;

	@Column
	public Boolean matterReady;

	@Column
	public String manufacturer;

	@Column
	public String modelNumber;

	@Column
	public String productName;

	@Column
	public String protocol;

}
