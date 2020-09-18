import java.util.Random;

public class RandomSumAndProduct2pm {

/**
 This function simply presents a banner that welcomes the user.
 */
    public static void welcomeUser() {
        System.out.println("***********************");
        System.out.println("    RANDOMNESS V1.0");
        System.out.println("***********************");
    }
    /**
     * This function computes the sum of three integers.
     * @param a The first of the three numbers to be added
     * @param b The second of the three numbers to be added
     * @param c The third of the three numbers to be added
     * @return The sum of a, b and c
     */
    public static int computeSum(int a, int b, int c) {
        int total = a + b + c;
        return total;
    }
    /**
     * This function computes the product of three integers.
     * @param a The first of the three numbers to be multiplied
     * @param b The second of the three numbers to be multiplied
     * @param c The third of the three numbers to be multiplied
     * @return The product of a, b and c
     */
    public static int computeProduct(int a, int b, int c) {
        int prod = a * b * c;
        return prod;
    }
   public static void main(String[] args) {
       welcomeUser();
        Random rnd = new Random();
        int x1, x2, x3;
        x1 = rnd.nextInt(25);
        x2 = rnd.nextInt(25);
        x3 = rnd.nextInt(25);
        int sum = computeSum(x1,x2,x3);
        int prod = computeProduct(x1,x2,x3);
        System.out.printf("The sum of %d, %d and %d is %d.\n", x1, x2, x3, sum);
        System.out.println("The product is " + prod + ".");
   } 
}
