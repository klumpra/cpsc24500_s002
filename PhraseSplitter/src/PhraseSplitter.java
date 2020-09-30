import java.util.Scanner;
import java.util.Arrays;
public class PhraseSplitter {
	public static void printWords(String[] words) {
		for (String word : words) {
			System.out.println(word);
		}
	}
	public static void makeLowerCase(String[] words) {
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a phrase: ");
		String phrase = sc.nextLine();
		String[] words = phrase.split(" ");
		printWords(words);
		makeLowerCase(words);
		System.out.println("Now sorted ...");
		Arrays.sort(words);
		printWords(words);
	}
}
