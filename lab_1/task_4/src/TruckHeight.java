import java.util.Scanner;

public class TruckHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество дорог: ");
        int roads = scanner.nextInt();
        int bestRoad = 0;
        int maxTruckHeight = -1;
        for (int i = 1; i <= roads; i++) {
            System.out.print("Введите количество туннелей для дороги номер " + i + " :");
            int tunnels = scanner.nextInt();
            int minTruckHeight = Integer.MAX_VALUE;
            System.out.print("Введите высоту туннелей: ");
            for (int j = 0; j < tunnels; j++) {
                int height = scanner.nextInt();
                if (height < minTruckHeight) {
                    minTruckHeight = height;
                }
            }

            if (minTruckHeight > maxTruckHeight) {
                maxTruckHeight = minTruckHeight;
                bestRoad = i;
            }
        }

        System.out.println("Номер дороги по которой нужно проехать: " + bestRoad + ", максимальная высота грузовика: " + maxTruckHeight);
        scanner.close();
    }
}