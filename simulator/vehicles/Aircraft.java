package simulator.vehicles;

import weather.Coordinates;

public class Aircraft {
	private long id;
	private String name;
	protected Coordinates coordinates;
	private long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		nextId(); // temp get rid of warn
		System.out.println(id + this.name); // temp get rid of warn
	}

	private long nextId() {
		return this.idCounter;
	}
}