import java.net.URL;
import java.util.Scanner;

/**
 * This program goes to the department homepage and grabs the data
 * that is there - all the html code that makes that page look the
 * way it does.
 * @author klumpra
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			URL link = new URL("http://www.cs.lewisu.edu/mathcs");
			Scanner fsc = new Scanner(link.openStream());
			while (fsc.hasNextLine()) {
				System.out.println(fsc.nextLine());
			}
			fsc.close();
		} catch (Exception ex) {	
			System.out.println("Couldn't connect to website.");
		}
	}
}
