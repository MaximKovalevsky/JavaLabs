import java.util.Arrays;
import java.util.Scanner;

public class Matrix90counterClock {
    public static int[][] move90Counter(int[][] matrix) {
        int n = matrix.length;
        int[][] moved = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moved[n - 1 - j][i] = matrix[i][j];
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

        int[][] moved = move90Counter(matrix);
        System.out.println("Матрица после поворота на 90 градусов против часовой стрелки:");
        for (int[] row : moved) {
            System.out.println(Arrays.toString(row));
        }
    }
}