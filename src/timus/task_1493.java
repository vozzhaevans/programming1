package timus;

    import java.util.Scanner;

    public class task_1493 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            if (isLucky(n + 1) || isLucky(n - 1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        private static boolean isLucky(int num) {
            int firstHalf = num / 1000;
            int secondHalf = num % 1000;
            return sumDigits(firstHalf) == sumDigits(secondHalf);
        }

        private static int sumDigits(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
    }