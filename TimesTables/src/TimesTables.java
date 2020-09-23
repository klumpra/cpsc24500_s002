import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This prints times tables so the youth of today can know them tomorrow.
 * @author klumpra
 *
 */
public class TimesTables {
	public static void printTimesTables(int cap) {
		int ans;
		for (int i = 1; i <= cap; i++) {
			for (int j = 1; j <= cap; j++) {
				ans = i * j;
				System.out.printf("%d * %d = %d\n", i, j, ans);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cap;
		do {
			try {
				System.out.print("Enter the cap: ");
				cap = sc.nextInt();
				if (cap <= 0) {
					System.out.println("The cap must be positive.");
				}
			} catch (Exception ex) {
				System.out.println("You needed to type an int.");
				cap = 0;
				sc.nextLine();  // clears the input channel
			}
		} while (cap <= 0);
		printTimesTables(cap);
	}
}
