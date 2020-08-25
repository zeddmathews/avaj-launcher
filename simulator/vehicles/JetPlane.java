package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	public JetPlane (String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = "JetPlane";
	}

	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {
		System.out.println(this.weatherTower); // temp get rid of warn
	}
}