package weather;

public class WeatherProvider {
	private WeatherProvider weatherprovider;
	private String [] weather = {
		"RAIN",
		"FOG",
		"SUN",
		"SNOW"
	};
	private WeatherProvider() {

	}

	public WeatherProvider getProvider() {
		return this.weatherprovider; // temp get rid of warn
	}

	public String getCurrentWeather(Coordinates coordinates) {
		return weather[0]; // temp get rid of warn
	}
}