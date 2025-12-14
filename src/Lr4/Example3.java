package Lr4;

public class Example3 {
    public static void main(String[] args) {
        int [][] h = {{2,2,2,2,2}, {2,2,2,2,2}, {2,2,2,2,2}, {2,2,2,2,2}, {2,2,2,2,2}};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + h[i][j] + " ");
            }
            System.out.println();
        }
    }
}
