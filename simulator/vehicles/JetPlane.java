package simulator.vehicles;

import simulator.WeatherTower;
import weather.Coordinates;

public class JetPlane extends Aircraft {
	private WeatherTower weatherTower;
	public JetPlane (String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {
		System.out.println(this.weatherTower); // temp get rid of warn
	}
}