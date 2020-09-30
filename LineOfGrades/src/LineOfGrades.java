import java.util.Scanner;
/**
 * This program reads a line of text that looks like this:
 * Ray	91	84	87
 * @author klumpra
 *
 */
public class LineOfGrades {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name and 3 scores separated by tabs: ");
		String input = sc.nextLine();
		String[] parts = input.split("\t");
		String name = parts[0];
		int gr1 = Integer.parseInt(parts[1]);
		int gr2 = Integer.parseInt(parts[2]);
		int gr3 = Integer.parseInt(parts[3]);
		double avg = (gr1 + gr2 + gr3) / 3.0;
		System.out.printf("%s %.2f\n", name,avg);
	}
}
