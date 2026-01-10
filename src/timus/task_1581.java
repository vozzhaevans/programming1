package timus;

import java.util.Scanner;

public class task_1581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                result.append(count).append(" ").append(arr[i - 1]).append(" ");
                count = 1;
            }
        }

        result.append(count).append(" ").append(arr[n - 1]);

        System.out.println(result.toString());
    }
}
