import java.util.Scanner;
/**
 * This program calculates the paycheck for an hourly employee.
 * @author klumpra
 *
 */
public class PaycheckCalculator {
	public static double calculateGrossPay(double payRate, double hours) {
		double result = payRate * hours;
		return result;
	}
	public static double getTaxRate(double gross) {
		if (gross > 2000) {
			return 0.25;
		} else if (gross > 1000) {
			return 0.15;
		} else {
			return 0.1;
		}
	}
	public static void main(String[] args) {
		double payRate;
		double hoursWorked;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter pay rate: ");
		payRate = sc.nextDouble();
		System.out.print("Enter hours worked: ");
		hoursWorked = sc.nextDouble();
		double gross = calculateGrossPay(payRate,hoursWorked);
		gross = Math.ceil(gross);
		System.out.printf("You worked %.2f hours at a rate of $%.2f.\n", hoursWorked,payRate);
		System.out.printf("Your gross pay is $%.2f.\n", gross);	
		double taxRate = getTaxRate(gross);
		double taxes = taxRate * gross;
		double net = gross - taxes;
		System.out.printf("Your take-home pay is $%.2f.\n", net);
	}
}
