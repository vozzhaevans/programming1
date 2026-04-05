package timus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task_1496 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String team = scanner.nextLine();
            countMap.put(team, countMap.getOrDefault(team, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
        scanner.close();
    }
}
