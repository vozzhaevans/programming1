package timus;
import java.util.Scanner;

public class task_1924 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // если сумма чисел четная, то и результат четный(черные), проверить четность суммы можно через n mod 4
        int mod = n % 4;

        if (mod == 0 || mod == 3) {
            System.out.println("black");
        } else {
            System.out.println("grimy");
        }

    }
}
