import java.util.Scanner;
import java.io.*;

public class ScoreReader {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fname;
		System.out.print("Enter the name of the file: ");
		fname = sc.nextLine();
		try {
			Scanner fsc = new Scanner(new File(fname));
			PrintWriter pw = new PrintWriter(new BufferedWriter(
					new FileWriter(new File("output.txt"))));
			String line, name;
			int score1, score2, score3;
			String[] parts;
			double avg;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				name = parts[0];
				score1 = Integer.parseInt(parts[1]);
				score2 = Integer.parseInt(parts[2]);
				score3 = Integer.parseInt(parts[3]);
				avg = (score1 + score2 + score3) / 3.0;
				System.out.printf("%-15s\t%.2f\n",name,avg);
				pw.printf("%-15s\t%.2f\n",name,avg);
			}
			fsc.close();
			pw.close();
		} catch (Exception ex) {
			System.out.println("Something happened as I tried to read the file. Boo.");
			ex.printStackTrace();
		}
	}
}
