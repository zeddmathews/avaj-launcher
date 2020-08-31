package simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

// import weather.Coordinates;
import simulator.exceptions.StandardException;
import simulator.vehicles.AircraftFactory;
import simulator.vehicles.Flyable;

public class Simulator {
	// Coordinates coordinates = new Coordinates(20, 30, 10);
	// Should be where everything gets put together??
	static BufferedReader br;
	static WeatherTower weatherTower;
	static ArrayList<Flyable> vehicles;
	static String arr[];
	static int totalSims;
	static int countSim;
	static BufferedWriter bW;
	static FileStuff writer = new FileStuff();
	public void createTextFile () {

	}
	public static void main(String[] args) throws StandardException, IOException, FileNotFoundException {
		// read file										done
		// error handle file								done
		// split lines										done
			// first line == number of simulations			done
			// everyline after 5 instances
			// first is aircraft name
			// second is aircraft number
			// three to five is lat, long, height
		// create tower										done
		// create aircraft									done
		// register aircraft to tower						done
		// run number of sims
		// put everything that happens into simulations.trxt
		try {
			if (args.length != 1) {
				throw new StandardException("Incorrect number of parameters. Use a single parameter of type file path");
			}
			else {
				br = new BufferedReader(new FileReader(args[0]));
				vehicles = new ArrayList<>();
				String line = "";
				int lineNum = 0;
				String vehicleType = "";
				String vehicleName = "";
				int longi = 0;
				int lat = 0;
				int height = 0;
				// get totalSims value and create weatherTower
				while (line != null) {
					line = br.readLine();
					if (lineNum == 0) {
						totalSims = Integer.parseInt(line);
						weatherTower = new WeatherTower();
						break ;
					}
					if (line == null || line.length() == 0) {
						continue ;
					}
					lineNum++;
				}
				System.out.println(lineNum);
				// handle coordinates and vehicle creation
				while (line != null) {
					line = br.readLine();
					lineNum++;
					if (line == null || line.length() == 0) {
						continue ;
					}
					arr = line.split(" ");
					if (arr.length == 0) {
						continue ;
					}
					if (arr.length != 5) {
						throw new StandardException("Scenario file has an invalid line at line: " + lineNum);
					}
					if (arr.length == 5) {
						try {
							vehicleType = arr[0];
							vehicleName = arr[1];
							longi = Integer.parseInt(arr[2]);
							lat = Integer.parseInt(arr[3]);
							height = Integer.parseInt(arr[4]);
							if (lat < 1 || longi < 1 || height < 1) {
								throw new StandardException("Negative coordinates not allowed");
							}
							else {
								vehicles.add(AircraftFactory.newAircraft(vehicleType, vehicleName, longi, lat, height));
							}
						}
						catch (Exception e) {
							e.getMessage();
						}
					}
				}
				br.close();
				for (Flyable vehicle : vehicles) {
					vehicle.registerTower(weatherTower);
				}
				countSim = 1;
				while (countSim <= totalSims) {
					System.out.println("Simulation number " + countSim);
					writer.writeData("Simulation #" + countSim);
					weatherTower.changeWeather();
					countSim++;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e){
			System.out.println(e.getMessage());
		} catch (StandardException e) {
			System.out.println(e.getMessage());
		} finally {
			writer.closeFile();
		}
	}
}