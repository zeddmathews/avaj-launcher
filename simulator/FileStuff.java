package simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStuff {
	static BufferedWriter bW;
	static File txtFile;
	public FileStuff() {
		try {
			txtFile = new File("simulations.txt");
			if (bW == null) {
				bW = new BufferedWriter(new FileWriter(txtFile));
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void writeData(String data) {
		try {
			bW.write(data);
			bW.newLine();
			bW.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	public void closeFile() {
		try {
			if (bW != null)
				bW.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}