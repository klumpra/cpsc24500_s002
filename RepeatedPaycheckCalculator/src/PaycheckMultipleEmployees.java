import java.util.Scanner;
public class PaycheckMultipleEmployees {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empCount;
		double hours, rate, gross;
		System.out.print("How many employees? ");
		empCount = sc.nextInt();
		for (int i = 0; i < empCount; i++) {
			System.out.print("Enter hours and rate: ");
			hours = sc.nextDouble();
			rate = sc.nextDouble();
			gross = hours * rate;
			System.out.printf("Gross = $%.2f.\n", gross);
		}
	}
}
