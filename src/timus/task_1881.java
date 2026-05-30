package timus;

import java.util.Scanner;

public class task_1881 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        int pages = 1;
        int linesOnCurrentPage = 1;
        int currentLineLength = 0;

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            int len = word.length();

            if (currentLineLength == 0) {
                currentLineLength = len;
            } else {
                if (currentLineLength + 1 + len <= w) {
                    currentLineLength += 1 + len;
                } else {
                    linesOnCurrentPage++;
                    currentLineLength = len;
                }
            }

            if (linesOnCurrentPage > h) {
                pages++;
                linesOnCurrentPage = 1;
            }
        }

        System.out.println(pages);
        sc.close();
    }
}
