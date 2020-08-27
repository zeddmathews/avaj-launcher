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
		// read file										done
		// error handle file								wip
		// split lines										done
			// first line == number of simulations			wip
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
			else {
				BufferedReader br = new BufferedReader(new FileReader(args[0]));
				String line = "";
				int lineNum = 0;
				String arr[] = null;
				int totalSims = 0;
				while (line != null) {
					arr = line.split(" ");
					if (lineNum == 1) {
						totalSims = Integer.parseInt(line);
						// System.out.println("Am here:" + line + "heh");
					}
					line = br.readLine();
					if (line == null || line.length() == 0) {
						continue;
					}
					// System.out.println(line.length());
					// System.out.println(line);
					lineNum++;
					// System.out.println(arr);
				}
				System.out.println(totalSims);
				System.out.println(arr.length);
				// for (String aircraft : arr) {
				// 	System.out.println(aircraft);
				// }
				br.close();
			}
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (StandardException e) {
				System.out.println(e.getMessage());
			}
	}
}