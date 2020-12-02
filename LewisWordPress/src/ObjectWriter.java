import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * DotWriter writes dots in a variety of file formats.
 * Eventually, it will write text, binary, xml, and json.
 * @author klumpra
 *
 */
public class ObjectWriter<T> {
	/**
	 * Write dots to a text file
	 * @param fname the name of the text file
	 * @param dots list of dots to write
	 * @return true if successfully written; false otherwise
	 */
	public boolean writeToText(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return writeToText(f,objects);  // delegation - lean on another function to do your task
	}
	/**
	 * writes dots to a file
	 * @param f the File object to write to
	 * @param dots the list of dots
	 * @return true if successfully written, false otherwise
	 */
	public boolean writeToText(File f, ArrayList<T> objects) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (T obj : objects) {
				pw.println(obj);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean writeToBinary(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return writeToBinary(f,objects);
	}
	
	public boolean writeToBinary(File f, ArrayList<T> objects) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(objects);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean write(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return write(f,objects);
	}
	public boolean writeToXML(String fname, ArrayList<T> objects) {
		File f = new File(fname);
		return writeToXML(f,objects);
	}
	public boolean writeToXML(File f, ArrayList<T> objects) {
		try {
			XMLEncoder enc = new XMLEncoder(new 
					BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(objects);
			enc.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * The write function serves as a hub that farms out to other write___ functions
	 * the responsibility of writing the data. It chooses which function to call
	 * based on the file extension.
	 * .txt - writeToText
	 * .bin - writeToBinary
	 * .xml - writeToXML
	 * @param f This is the file object
	 * @param dots The dots to write
	 * @return true if successful, false otherwise (including if unrecognized extension)
	 */
	public boolean write(File f, ArrayList<T> objects) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return writeToText(f,objects);
			} else if (fname.endsWith(".BIN")) {
				return writeToBinary(f,objects);
			} else if (fname.endsWith(".XML")) {
				return writeToXML(f,objects);
			} else {
				return false;  // unrecognized file format
			}
		} catch (Exception ex) {
			return false;
		}
	}
}
