import java.util.Arrays;
import java.util.Scanner;

public class MaxInRow {
    public static int[] maxInRow(int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы (n x m):");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        System.out.println("Введите элементы матрицы построчно:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] result = maxInRow(matrix);
        System.out.println("Максимальные элементы в каждой строке: " + Arrays.toString(result));
    }
}