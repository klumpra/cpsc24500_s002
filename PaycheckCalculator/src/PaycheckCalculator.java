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
	}
}
