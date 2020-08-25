package weather;

public class WeatherProvider {
	private static WeatherProvider weatherprovider;
	private static String [] weather = {
		"RAIN",
		"FOG",
		"SUN",
		"SNOW"
	};
	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		return new WeatherProvider();
	}

	public String getCurrentWeather(Coordinates coordinates) {
		// make randomizer to get weather type or build specific ranges for weather type
		return weather[0]; // temp get rid of warn
	}
}