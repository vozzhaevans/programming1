package timus;

import java.util.Scanner;

public class task_1723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int n = s.length();
        String bestSub = "";
        int bestCount = 0;

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                String sub = s.substring(start, start + len);
                int count = 0;
                for (int i = 0; i + len <= n; i++) {
                    if (s.substring(i, i + len).equals(sub)) {
                        count++;
                    }
                }
                if (count > bestCount) {
                    bestCount = count;
                    bestSub = sub;
                }
            }
        }

        System.out.println(bestSub);
    }
}
