import java.util.Scanner;

public class TwiceEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int hundreds = n / 100;
        int tens = (n / 10) % 10;
        int units = n % 10;
        int summ = hundreds + tens + units;
        int product = hundreds * tens * units;

        boolean isSumEven = summ % 2 == 0;
        boolean isProductEven = product % 2 == 0;

        System.out.println(isSumEven && isProductEven ? "YES" : "NO");
    }
}