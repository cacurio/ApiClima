package com.arcos.servicio.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.arcos.servicio.domain.Clima;
import com.arcos.servicio.service.ClimaService;

@RestController
public class ClimaControlador {

	@Autowired
	ClimaService climaService;
	
	@GetMapping("/clima/{city}")
	public  List<ClimaResumen> getClimaCiudad(@PathVariable("city") String city) {
		List<ClimaResumen> resumen = new ArrayList<>();
		if (!"".equals(city)) {
			resumen = getResumen(city);
		}
		return resumen;
	}
	
	protected List<ClimaResumen> getResumen(String city) {
		List<ClimaResumen> resumen = new ArrayList<>();
		Clima clima = this.climaService.getClima(city);
		if(clima!=null) {
			resumen.add(new ClimaResumen(city, clima));
		}
		return resumen;
		
	}
}
