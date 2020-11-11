import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DotReader {
	public ArrayList<Dot> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	public ArrayList<Dot> readFromText(File f) {
		try {
			ArrayList<Dot> dotsRead = new ArrayList<Dot>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int x, y, r;
			Dot dot;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				x = Integer.parseInt(parts[0]);
				y = Integer.parseInt(parts[1]);
				r = Integer.parseInt(parts[2]);
				dot = new Dot(x,y,r);
				dotsRead.add(dot);
			}
			fsc.close();
			return dotsRead;
		} catch (Exception ex) {
			return null;  // null means I wasn't able to build 
						  // the required array list of dots
		}
	}
	public ArrayList<Dot> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<Dot> readFromBinary(File f) {
		try {
			ArrayList<Dot> dotsRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			dotsRead = (ArrayList<Dot>)ois.readObject();
			ois.close();
			return dotsRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Dot> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	public ArrayList<Dot> read(File f) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return readFromText(f);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(f);
			} else {
				return null;  // unrecognized extension
			}
		} catch (Exception ex) {
			return null;
		}
	}
}
