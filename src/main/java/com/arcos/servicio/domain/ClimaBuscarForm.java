package com.arcos.servicio.domain;

import javax.validation.constraints.NotNull;

public class ClimaBuscarForm {

	@NotNull
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ClimaBuscarForm [city=" + city + "]";
	}
	
	

}
