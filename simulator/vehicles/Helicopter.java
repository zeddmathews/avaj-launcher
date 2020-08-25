package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "Helicopter";
	}

	public void updateConditions() {
	}

	public void registerTower(WeatherTower weatherTower) {
		System.out.println(this.weatherTower); // temp get rid of warn
	}
}