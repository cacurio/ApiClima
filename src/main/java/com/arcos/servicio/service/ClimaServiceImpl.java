package com.arcos.servicio.service;

import java.net.URI;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.arcos.servicio.EndPontClimaApplicationProperties;
import com.arcos.servicio.domain.Clima;

@Service
public class ClimaServiceImpl implements ClimaService {

	private final String apiUrl;

	private final RestTemplate restTemplate;

	private final String apiKey;
	
	

	public ClimaServiceImpl(RestTemplate restTemplate, EndPontClimaApplicationProperties properties) {
		this.restTemplate=restTemplate;
		this.apiKey=properties.getApi().getKey();
		this.apiUrl=properties.getApi().getUrl();
		
	}
	


	@Override
	@Cacheable("clima")
	public Clima getClima(String city) {
		// TODO Auto-generated method stub
		Clima clima= null;
		if(validParameters(city)) {
			URI url = new UriTemplate(this.apiUrl).expand(city, this.apiKey);
			clima= invoke(url, Clima.class);
		}
		
		return clima;
	}
	
	private boolean validParameters(String city) {
		return city !=null && !"".equals(city) && apiKey !=null && !"".equals(apiKey) && apiUrl!=null && !"".equals(apiUrl);
	}
	
	private <T> T invoke(URI url, Class<T> responseType){
		T weather = null;
		try {
			RequestEntity<?> request = RequestEntity.get(url)
					.accept(MediaType.APPLICATION_JSON).build();
			ResponseEntity<T> exchange = this.restTemplate
					.exchange(request, responseType);
			weather = exchange.getBody();
		} catch(Exception e){
				 System.out.println("Error  " + e.getMessage());
		}

		return weather;
	}

}
