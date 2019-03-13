package com.arcos.servicio;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("app.clima")
public class EndPontClimaApplicationProperties {
	
	private final Api api = new Api();
	
	public Api getApi() {
		return this.api;
	}
	
	//********************************
	/*
	 * Clase estatica de los parametros
	 */
	//********************************
	
	public static class Api {

		@NotNull
		private String key;

		@NotNull
		private String url;

		/*
		 * GET y SET
		 */
		
		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}


}
