package Lr4;

public class Example7 {
    public static void main(String[] args) {
        int[][] snake = new int[9][9];
        int num = 1;
        int direction = 1;
        int row = 0;
        int col = 0;

        for (row = 0; row < 9; row++) {
            if (row % 2 == 0) {
                // Четные строки: слева направо
                for (col = 0; col < 9; col++) {
                    snake[row][col] = num++;
                }
            } else {
                // Нечетные строки: справа налево
                for (col = 9 - 1; col >= 0; col--) {
                    snake[row][col] = num++;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%3d", snake[i][j]);
            }
            System.out.println();
        }
    }
}
