import java.util.Scanner;
/**
 * This program allows the user to calculate areas of circles and rectangles.
 * @author klumpra
 *
 */
public class AreaCalculator {
	public static int showMenuAndGetChoice(Scanner sc) {
		int choice;
		do {
			System.out.println("Here are your options: ");
			System.out.println("1. Circle");
			System.out.println("2. Rectangle");
			System.out.println("3. Quit");
			System.out.print("Enter the number of your choice: ");
			try {
				choice = sc.nextInt();
				if (choice <= 0 || choice > 3) {
					System.out.println("That is an invalid choice.");
				}
			} catch (Exception ex) {
				System.out.println("You needed to enter a number.");
				sc.nextLine();  // clears the garbage on the input channel
				choice = 0;
			}
		} while (choice <= 0 || choice > 3);
		return choice;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;  // the user's selection
		double rad, length, width, area;
		do {
			choice = showMenuAndGetChoice(sc);
			if (choice == 1) {
				System.out.print("Enter the radius: ");
				rad = sc.nextDouble();
				area = Math.PI * rad * rad;
				System.out.printf("The area of the circle is %.3f.\n", area);
			} else if (choice == 2) {
				System.out.print("Enter the length and the width: ");
				length = sc.nextDouble();
				width = sc.nextDouble();
				area = length * width;
				System.out.printf("The area of the rectangle is %.3f.\n", area);
			}
		} while (choice != 3);
		System.out.println("Thank you for using this program.");
	}
}
