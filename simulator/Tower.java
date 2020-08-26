package simulator;

import java.util.ArrayList;

import simulator.vehicles.Flyable;


public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();
	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {

	}
}