import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class FunWithArrayLists {
	public static void printNames(ArrayList<String> names) {
		/*
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		*/
		for (String name : names) {
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		names.add("Ray");
		names.add("Karen");
		names.add("Conor");
		names.add("Lauren");
		names.add("Evan");
		System.out.print("Which slot do you want me to report: ");
		int pos = sc.nextInt();
		String target = names.get(pos);
		System.out.println("That name is " + target);
		System.out.println("Here is the list of names: ");
		printNames(names);
		System.out.print("Enter a new name to add and where to insert it: ");
		String newName = sc.next();
		pos = sc.nextInt();
		names.add(pos,newName);
		printNames(names);
		System.out.println("Here is the list of names sorted: ");
		Collections.sort(names);
		printNames(names);
		sc.close();
		System.out.println("Now removing the old geezer who can't type: ");
		names.remove("Ray");
		printNames(names);
		System.out.println("Now will remove the item at location 1: ");
		names.remove(1);
		printNames(names);
	}
}
