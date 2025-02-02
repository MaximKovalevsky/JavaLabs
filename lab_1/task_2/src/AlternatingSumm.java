import java.util.Scanner;

public class AlternatingSumm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int sum = 0;
        System.out.print("Введите числа: ");
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (i % 2 == 0) {
                sum += number;
            } else {
                sum -= number;
            }
        }
        System.out.println("Знакочередующаяся сумма: " + sum);
        scanner.close();
    }
}