import java.util.Arrays;
import java.util.Scanner;

public class MaxSumm {
    public static int SummMax(int[] mas) {
        int s = mas[0];
        int currentS = mas[0];

        for (int i = 1; i < mas.length; i++) {
            currentS = Math.max(mas[i], currentS + mas[i]);
            s = Math.max(s, currentS);
        }

        return s;
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы массива через пробел:");
        int[] mas = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = SummMax(mas);
        System.out.println("Максимальная сумма подмассива: " + result);
    }
}