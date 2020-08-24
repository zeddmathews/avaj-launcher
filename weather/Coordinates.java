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
	public static int getLongitude(int longitude) {
		return longitude;
	}

	public static int getLatitude(int latitude) {
		return latitude;
	}

	public static int getHeight(int height) {
		return height;
	}
}