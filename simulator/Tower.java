package simulator;

import java.util.ArrayList;

import simulator.vehicles.Flyable;


public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();
	public void register(Flyable flyable) {
		observers.add(flyable);
		// System.out.println(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		int index = 0;
		final int obsSize = observers.size();
		while (index < obsSize) {
			observers.get(index).updateConditions();
		}
	}
}