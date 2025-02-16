import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    public static int[] merge(int[] mas1, int[] mas2) {
        int n = mas1.length;
        int m = mas2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (mas1[i] < mas2[j]) {
                result[k++] = mas1[i++];
            } else {
                result[k++] = mas2[j++];
            }
        }

        while (i < n) {
            result[k++] = mas1[i++];
        }

        while (j < m) {
            result[k++] = mas2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы первого отсортированного массива через пробел:");
        int[] arr1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Введите элементы второго отсортированного массива через пробел:");
        int[] arr2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = merge(arr1, arr2);
        System.out.println("Объединенный отсортированный массив: " + Arrays.toString(result));
    }
}