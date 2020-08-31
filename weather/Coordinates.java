package weather;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;


	public Coordinates(int longitude, int latitude, int height) {
		if (longitude < 1) {
			this.longitude = 1;
		}
		else {
			this.longitude = longitude;
		}
		if (latitude < 1) {
			this.latitude = 1;
		}
		else {
			this.latitude = latitude;
		}
		if (height > 100) {
			this.height = 100;
		}
		else if (height < 0) {
			this.height = 0;
		}
		else {
			this.height = height;
		}
	}
	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public String coordsString() {
		return this.getLongitude() + " " + this.getLatitude() + " " + this.getHeight();
	}
}