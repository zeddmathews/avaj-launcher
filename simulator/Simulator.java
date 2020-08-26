package simulator;

// import java.io.BufferedReader;
// import java.io.FileReader;

// import weather.Coordinates;
import simulator.exceptions.StandardException;

public class Simulator {
	// Coordinates coordinates = new Coordinates(20, 30, 10);
	// Should be where everything gets put together??
	public static void main(String[] args) throws StandardException {
		// read file
		// error handle file
		// split lines
			// first line == number of simulations
			// everyline after 5 instances
			// first is aircraft name
			// second is aircraft number
			// three to five is lat, long, height
		// create tower
		// create aircraft
		// register aircraft to tower
		// run number of sims
		System.out.println(args.length);
		if (args.length != 1) {
			throw new StandardException("File not found");
		}
		// try {
		// 	BufferedReader br = new BufferedReader(new FileReader(args[1]));
		// 	String line = null;
		// 	while (line != null) {
		// 		line = br.readLine();
		// 		System.out.println(line);
		// 	}
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }
	}
}