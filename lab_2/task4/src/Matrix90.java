import java.util.Arrays;
import java.util.Scanner;

public class Matrix90 {
    public static int[][] move90(int[][] matrix) {
        int n = matrix.length;
        int[][] moved = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moved[j][n - 1 - i] = matrix[i][j];
            }
        }

        return moved;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер квадратной матрицы:");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Введите элементы матрицы построчно:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] rotated = move90(matrix);
        System.out.println("Матрица после поворота на 90 градусов по часовой стрелке:");
        for (int[] row : rotated) {
            System.out.println(Arrays.toString(row));
        }
    }
}