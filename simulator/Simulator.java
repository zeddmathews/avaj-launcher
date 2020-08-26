package simulator;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

// import weather.Coordinates;
import simulator.exceptions.StandardException;

public class Simulator {
	// Coordinates coordinates = new Coordinates(20, 30, 10);
	// Should be where everything gets put together??
	public static void main(String[] args) throws StandardException, IOException, FileNotFoundException {
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
		try {
			if (args.length != 1) {
				throw new StandardException("Incorrect number of parameters. Use a single parameter of type file path");
			}
				BufferedReader br = new BufferedReader(new FileReader(args[0]));
				String line = "";
				while (line != null) {
					// if (line == null || line.length() == 0) {

					// }
					// String arr[] = line.split(" ");
					System.out.println(line.length());
					line = br.readLine();
					System.out.println(line);
				}
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (StandardException e) {
				System.out.println(e.getMessage());
			}
	}
}