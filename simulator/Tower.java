package simulator;

import simulator.vehicles.Flyable;

public class Tower {
	private Flyable observers;
	public void register(Flyable flyable) {
		System.out.println(observers); // temp get rid of warn
	}

	public void unregister(Flyable flyable) {

	}

	protected void conditionsChanged() {

	}
}