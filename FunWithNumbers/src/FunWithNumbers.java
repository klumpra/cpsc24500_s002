import java.util.Scanner;
public class FunWithNumbers {
	public static int printMenuAndGetChoice(Scanner sc) {
		int choice;
		System.out.println("What would you like to do? ");
		System.out.println("1. Add");
		System.out.println("2. Sub");
		System.out.println("3. Mult");
		System.out.println("4. Divide");
		System.out.println("5. Quit");
		System.out.print("Enter the number of your choice: ");
		choice = sc.nextInt();
		return choice;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, choice;
		int sum, diff, prod;
		double quot;
		System.out.print("Enter two ints: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		do {
			choice = printMenuAndGetChoice(sc);
			if (choice == 1) {
				sum = num1 + num2;
				System.out.printf("%d + %d = %d\n", num1,num2,sum);
			} else if (choice == 2) {
				diff = num1 - num2;
				System.out.printf("%d - %d = %d\n", num1,num2,diff);
			} else if (choice == 3) {
				prod = num1 * num2;
				System.out.printf("%d * %d = %d\n", num1,num2,prod);
			} else if (choice == 4) {
				quot = (double)num1 / num2;
				System.out.printf("%d / %d = %.2f\n", num1,num2,quot);
			} else if (choice > 5 || choice <= 0) {
				System.out.println("You didn't enter a valid choice.");
			}
		} while (choice != 5);
	}
}
