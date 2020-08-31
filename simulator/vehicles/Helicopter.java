package simulator.vehicles;

import java.util.HashMap;
import simulator.WeatherTower;
import weather.Coordinates;
import simulator.FileStuff;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	FileStuff writer = new FileStuff();

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "Helicopter";
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		HashMap<String, String> weatherResponse = new HashMap<>();
		weatherResponse.put("RAIN", "This RAIN has me soaked");
		weatherResponse.put("FOG", "My vision is bad enough without all this FOG");
		weatherResponse.put("SUN", "I don't have AC for this level of SUN");
		weatherResponse.put("SNOW", "SNOW is mildly problematic without a barrier in between it and you");
		if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
		}
		else if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
		}
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.unregister(this);
		}
		writer.writeData(this.vehicleData() + ": " + weatherResponse.get(weather));

		if (this.coordinates.getHeight() == 0) {
			writer.writeData(this.vehicleData() + ": is landing. Coordinates: " + this.coordinates.coordsString());
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}