import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SummOfTwo {
    public static int[] findPair(int[] mas, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < mas.length; i++) {
            int complement = target - mas[i];
            if (map.containsKey(complement)) {
                return new int[]{complement, mas[i]};
            }
            map.put(mas[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы массива через пробел:");
        int[] mas = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Введите целевое число (target):");
        int target = scanner.nextInt();
        int[] result = findPair(mas, target);
        if (result != null) {
            System.out.println("Пара чисел: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println(result);
        }
    }
}