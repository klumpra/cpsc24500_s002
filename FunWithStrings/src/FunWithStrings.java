import java.util.Scanner;
public class FunWithStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String phrase;
		System.out.print("Enter a phrase: ");
		phrase = sc.nextLine();
		int charCount = phrase.length();
		System.out.printf("There are %d chars in the phrase.\n", charCount);
		System.out.println("In uppercase, the phrase is " + phrase.toUpperCase());
		System.out.print("Enter a string to search for: ");
		String searchFor = sc.nextLine();
		int loc = phrase.indexOf(searchFor);
		if (loc < 0) {
			System.out.println("not found");
		} else {
			System.out.printf("Found at pos %d.\n", loc);
		}
		System.out.println("Here are characters 3 through 7: ");
		String part = phrase.substring(3,8);
		System.out.println(part);
		sc.close();
	}
}
