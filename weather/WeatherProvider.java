package weather;

import java.util.Random;

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
		if (weatherprovider == null) {
			weatherprovider = new WeatherProvider();
		}
		return weatherprovider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int upperBound = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
		int rand = 120 + new Random().nextInt(upperBound);
		return weather[rand % 8];
	}
}