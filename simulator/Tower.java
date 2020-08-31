package simulator;

import java.util.ArrayList;

import simulator.vehicles.Flyable;

public abstract class Tower {
	FileStuff writer = new FileStuff();
	private boolean thing = false;
	private ArrayList<Flyable> observers = new ArrayList<>();
	public void register(Flyable flyable) {
		observers.add(flyable);
		writer.writeData("Tower says: " + flyable.vehicleData() +  " registered to weather tower");
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
		thing = true;
		writer.writeData("Tower says: " + flyable.vehicleData() + " unregistered from weather tower");
	}

	protected void conditionsChanged() {
		int index = 0;
		while (index < observers.size()) {
			if (thing == true) {
				index--;
				thing = false;
			}
			observers.get(index).updateConditions();
			index++;
		}
	}
}