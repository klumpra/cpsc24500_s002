import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * DotWriter writes dots in a variety of file formats.
 * Eventually, it will write text, binary, xml, and json.
 * @author klumpra
 *
 */
public class DotWriter {
	/**
	 * Write dots to a text file
	 * @param fname the name of the text file
	 * @param dots list of dots to write
	 * @return true if successfully written; false otherwise
	 */
	public boolean writeToText(String fname, ArrayList<Dot> dots) {
		File f = new File(fname);
		return writeToText(f,dots);  // delegation - lean on another function to do your task
	}
	/**
	 * writes dots to a file
	 * @param f the File object to write to
	 * @param dots the list of dots
	 * @return true if successfully written, false otherwise
	 */
	public boolean writeToText(File f, ArrayList<Dot> dots) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Dot dot : dots) {
				pw.println(dot);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
}
