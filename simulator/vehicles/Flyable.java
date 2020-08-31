package simulator.vehicles;

import simulator.WeatherTower;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
	String vehicleData();
}