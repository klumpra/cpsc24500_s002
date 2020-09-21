import java.util.Scanner;
public class PaycheckMultipleEmployees {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double hours, rate, gross;
		String doAgain;
		do {
			System.out.print("Enter hours and rate: ");
			hours = sc.nextDouble();
			rate = sc.nextDouble();
			gross = hours * rate;
			System.out.printf("Gross = $%.2f.\n", gross);
			System.out.print("Again? ");
			doAgain = sc.next(); 
		} while (doAgain.equalsIgnoreCase("y"));
		System.out.println("Thank you for using this program.");
	}
}
