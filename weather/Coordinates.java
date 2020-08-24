package weather;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;


	public Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}
	public int getLongitude(int longitude) {
		return this.longitude;
	}

	public int getLatitude(int latitude) {
		return this.latitude;
	}

	public int getHeight(int height) {
		return this.height;
	}
}