import java.util.Random;

public class RandomSumAndProduct {
   public static void main(String[] args) {
        Random rnd = new Random();
        int x1, x2, x3;
        x1 = rnd.nextInt(25);
        x2 = rnd.nextInt(25);
        x3 = rnd.nextInt(25);
        int sum = x1 + x2 + x3;
        int prod = x1 * x2 * x3;
        System.out.printf("The sum of %d, %d and %d is %d.\n", x1, x2, x3, sum);
        System.out.println("The product is " + prod + ".");
   } 
}
