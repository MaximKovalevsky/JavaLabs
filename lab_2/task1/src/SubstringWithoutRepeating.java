import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubstringWithoutRepeating {
    public static String LongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int length = 0;
        int start = 0;
        int maxStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            charIndexMap.put(currentChar, end);

            if (end - start + 1 > length) {
                length = end - start + 1;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        String result = LongestSubstring(input);
        System.out.println("Наибольшая подстрока без повторяющихся символов: " + result);

        scanner.close();
    }
}