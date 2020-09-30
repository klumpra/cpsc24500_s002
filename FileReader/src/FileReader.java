import java.util.Scanner;
import java.io.File;

public class FileReader {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of file to read: ");
		String fname = sc.nextLine();
		String line;
		try {
			Scanner fsc = new Scanner(new File(fname));
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				System.out.println(line);
			}
			fsc.close();
		} catch (Exception ex) {
			System.out.println("We couldn't read the file.");
		}
	}
}
