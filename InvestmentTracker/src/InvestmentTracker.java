import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class InvestmentTracker {
	public static LinkedHashMap<String, double[]> readData(Scanner sc) {
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		
		return result;
	}
	public static void main(String[] args) {
		LinkedHashMap<String, double[]> accounts;
		try {
			Scanner fsc = new Scanner(new File("investments.txt"));
			accounts = readData(fsc);
		} catch (Exception ex) {
			
		}
	}
}
