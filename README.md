# Introducción
WeatherApp: esta aplicación devolverá los datos meteorológicos actuales de OpenWeatherMap.org, según la ciudad elegida por el usuario.

# Fuente de datos
Los datos meteorológicos se leen desde http://openweathermap.org/ utilizando la API http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}

# Requisito previo
Para usar esta aplicación, necesita registrar una clave de API en http://openweathermap.org/ service.
Actualice la URL de la API y la clave en src/main/resources/application-prod.properties

# Cómo utilizar
- Acceda al recurso GET http://localhost:8080/clima en un cliente REST
- Ingrese el nombre de la ciudad

