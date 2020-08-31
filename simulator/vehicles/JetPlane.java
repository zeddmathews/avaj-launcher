package simulator.vehicles;

import java.util.HashMap;
import simulator.WeatherTower;
import weather.Coordinates;
import simulator.FileStuff;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	FileStuff writer = new FileStuff();

	public JetPlane (String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "JetPlane";
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		HashMap<String, String> weatherResponse = new HashMap<>();
		weatherResponse.put("RAIN", "This RAIN has me soaked");
		weatherResponse.put("FOG", "My vision is bad enough without all this FOG");
		weatherResponse.put("SUN", "I don't have AC for this level of SUN");
		weatherResponse.put("SNOW", "SNOW is mildly problematic without a barrier in between it and you");
		if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
		}
		else if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
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