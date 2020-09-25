import java.util.Random;
import java.util.Arrays;
public class ArrayOfRandoms {
	public static void printNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	public static void main(String[] args) {
		Random rnd = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rnd.nextInt(100);
		}
		System.out.println("Here are the numbers: ");
		printNumbers(numbers);
		Arrays.sort(numbers);
		System.out.println("now sorted ...");
		printNumbers(numbers);
	}
}
