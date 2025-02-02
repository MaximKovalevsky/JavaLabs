import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату клада по оси X: ");
        int treasureX = scanner.nextInt();
        System.out.print("Введите координату клада по оси Y: ");
        int treasureY = scanner.nextInt();
        int x = 0;
        int y = 0;
        int instructionsCount = 0;
        int minInstructions = 0;
        boolean treasureFound = false;

        while (true) {
            String direction = scanner.next();

            if (direction.equals("стоп")) {
                break;
            }

            int steps = scanner.nextInt();
            instructionsCount++;

            switch (direction) {
                case "север":
                    y += steps;
                    break;
                case "юг":
                    y -= steps;
                    break;
                case "восток":
                    x += steps;
                    break;
                case "запад":
                    x -= steps;
                    break;
                default:
                    System.out.println("Неверное направление!");
                    break;
            }

            if (x == treasureX && y == treasureY && !treasureFound) {
                minInstructions = instructionsCount;
                treasureFound = true;
            }
        }
        System.out.println("Минимальное количество указаний: " + minInstructions);
        scanner.close();
    }
}