import java.util.LinkedHashMap;
import java.util.Scanner;

public class Groceries {
	public static void main(String[] args) {
		LinkedHashMap<String,Double> groceries = new LinkedHashMap<String,Double>();
		groceries.put("apples",0.49);
		groceries.put("milk",1.79);
		groceries.put("bread",1.19);
		Scanner sc = new Scanner(System.in);
		System.out.print("What item do you want? ");
		String lookup = sc.next();
/*		try {
			double price = groceries.get(lookup);
			System.out.println(price);
		} catch (Exception ex) {
			System.out.println("Not found.");
		}
*/
		double price;
		if (groceries.containsKey(lookup)) {
			price = groceries.get(lookup);
			System.out.println(price);
		} else {
			System.out.println("not found");
			System.out.println("These are the items we have: ");
			for (String key: groceries.keySet()) {
				System.out.printf("%s: $%.2f\n",key,groceries.get(key));
			}
		}
	}
}
