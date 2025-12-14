package Lr4;

public class Example4 {
    public static void main(String[] args) {
        int[][] h = new int[5][5];

        for (int i = 0; i < h.length; i++) {  // length переменная которая хранит это значение
            for (int j = 0; j <= i; j++) {
                h[i][j] = 2;
            }
        }

        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < h[i].length; j++) {
                if (h[i][j] != 0) {
                    System.out.print(h[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
