package timus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class task_1563 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueShops = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String shop = scanner.nextLine();
            uniqueShops.add(shop);
        }

        int visited = uniqueShops.size();
        int notVisited = n - visited;

        System.out.println(notVisited);
        scanner.close();
    }
}