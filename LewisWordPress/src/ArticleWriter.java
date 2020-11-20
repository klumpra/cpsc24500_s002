import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This is our controller.
 * It takes the data from our Model (Article) and writes it to our view (JSON file
 * on the hard drive)
 * @author klumpra
 *
 */
public class ArticleWriter {
	public boolean writeToJSON(String fname, ArrayList<Article> articles) {
		try {
			File f = new File(fname);
			/*
			 * JSON is written to text files.
			 * To write to a text file, you need a PrintWriter
			 * Create JSONArray
			 * Then, for each article, create a JSONObject for it and add it to the JSONArray
			 * After that, create the outer JSONObject. It will have just one value in it,
			 * the array of article objects you filled.
			 * Then write that one outer object to the PrintWriter.
			 */
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
