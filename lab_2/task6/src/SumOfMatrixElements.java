import java.util.Scanner;

public class SumOfMatrixElements {
    public static int summ(int[][] matrix) {
        int s = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                s += num;
            }
        }
        return s;
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

        int result = summ(matrix);
        System.out.println("Сумма всех элементов: " + result);
    }
}