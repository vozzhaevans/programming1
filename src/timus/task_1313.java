package timus;
import java.util.Scanner;

public class task_1313 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] result = new int[N * N];
        int index = 0;

        for (int d = 0; d < 2 * N - 1; d++) {
            int startRow = Math.min(d, N - 1);
            int startCol = Math.max(0, d - (N - 1));
            int count = Math.min(startRow + 1, N - startCol);

            for (int i = 0; i < count; i++) {
                int row = startRow - i;
                int col = startCol + i;
                result[index++] = matrix[row][col];
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            output.append(result[i]);
            if (i < result.length - 1) {
                output.append(" ");
            }
        }
        System.out.println(output.toString());

        scanner.close();
    }

}
