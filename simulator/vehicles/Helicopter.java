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
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}