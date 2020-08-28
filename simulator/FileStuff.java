package simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileStuff {
	static BufferedWriter bW;
	static File txtFile;
	FileStuff() {
		try {
			txtFile = new File("simulations.txt");
			if (bW == null) {
				bW = new BufferedWriter(new FileWriter(txtFile));
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
}