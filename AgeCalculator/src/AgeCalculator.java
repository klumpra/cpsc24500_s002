import java.util.Scanner;
/**
 * Ask the user for their age and then comment on it.
 * Illustrates the use of conditional statements - ifs
 * @author klumpra
 *
 */
public class AgeCalculator {

	public static void welcome() {
		System.out.println("** Welcome to Age Calculator");
		System.out.println("Not fun, but interesting nonetheless");
	}
	/**
	 * This converts age in years to months and returns it.
	 * @param years age 
	 * @return age in months
	 */
	public static int getAgeInMonths(int years) {
		return years * 12;
	}
	public static void main(String[] args) {
		welcome();
		Scanner sc = new Scanner(System.in);
		System.out.print("What is your first name? ");
		String name = sc.next();
		System.out.print("How old are you in years? ");
		int age = sc.nextInt();
		System.out.printf("Thank you, %s. I see you are %d years old.\n", name, age);
		int ageInMonths = getAgeInMonths(age);
		System.out.printf("You are %d months old.\n", ageInMonths);
		if (age < 12) {
			System.out.println("Don't get beat up at recess.");
		} else if (age < 18) {
			System.out.println("Life is getting confusing.");
		} else if (age < 22) {
			System.out.println("College life is the best life.");
		} else if (age < 30) {
			System.out.println("Loans suck.");
		} else {
			System.out.println("Leave money for the undertaker.");
		}
		System.out.print("Are you happy (y or n)? ");
		String happyStr  = sc.next().toLowerCase().trim();
		if (happyStr.equals("y")) {
			System.out.println("That is good to hear.");
		} else {
			System.out.println("Cheer up, Buttercup");
		}
	}
}
