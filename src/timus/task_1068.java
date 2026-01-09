package timus;
import java.util.Scanner;

public class task_1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int sum;
        if (N >= 1) {
            sum = N * (N + 1) / 2;
        } else if (N <= -1) {
            int positiveN = -N;
            sum = 1 - (positiveN * (positiveN + 1) / 2);
        } else {
            sum = 1;
        }

        System.out.println(sum);
        scanner.close();
    }

}
