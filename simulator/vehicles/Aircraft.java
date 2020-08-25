package simulator.vehicles;

import weather.Coordinates;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected String type;
	private static long idCounter = 1;

	protected Aircraft(String name, Coordinates coordinates) {
		this.id = this.nextId();
		this.name = name;
		this.coordinates = coordinates;
		this.type = "Aircraft";
	}

	private long nextId() {
		return Aircraft.idCounter++;
	}
}