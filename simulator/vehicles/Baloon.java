package simulator.vehicles;

import java.util.HashMap;
import simulator.WeatherTower;
import weather.Coordinates;
import simulator.FileStuff;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	FileStuff writer = new FileStuff();

	public Baloon (String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "Baloon";
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
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