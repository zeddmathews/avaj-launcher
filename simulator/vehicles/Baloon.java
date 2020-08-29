package simulator.vehicles;

import java.util.HashMap;
import simulator.WeatherTower;
import weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	public Baloon (String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "Baloon";
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		HashMap<String, String> weatherResponse = new HashMap<>();
		weatherResponse.put("RAIN", "This RAIN has me soaked");
		weatherResponse.put("FOG", "My vision is bad enough without all this FOG");
		weatherResponse.put("SUN", "I don't have AC for this level of SUN");
		weatherResponse.put("SNOW", "SNOW is mildly problematic without a barrier in between it and you");
		if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
		}
		else if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 3);
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
		}
		// unregister on height == 0
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}