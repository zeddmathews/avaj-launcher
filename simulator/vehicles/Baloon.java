package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	public Baloon (String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "Baloon";
	}

	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {
		System.out.println(this.weatherTower); // temp get rid of warn
	}
}