package simulator.vehicles;

import simulator.exceptions.StandardException;
import weather.Coordinates;

public abstract class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws StandardException {
		String lowerType = type.toLowerCase();
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (lowerType.equals("baloon")) {
			Baloon baloon = new Baloon(name, coordinates);
			return baloon;
		}
		else if (lowerType.equals("helicopter")) {
			Helicopter helicopter = new Helicopter(name, coordinates);
			return helicopter;
		}
		else if (lowerType.equals("jetplane")){
			JetPlane jetPlane = new JetPlane(name, coordinates);
			return jetPlane;
		}
		else {
			throw new StandardException("Invalid aircraft name");
		}
	}
}