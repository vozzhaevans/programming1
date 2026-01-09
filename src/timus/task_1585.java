package timus;
import java.util.Scanner;

public class task_1585 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int emperorCount = 0;
        int littleCount = 0;
        int macaroniCount = 0;

        for (int i = 0; i < n; i++) {
            String penguin = scanner.nextLine().trim();

            if (penguin.equals("Emperor Penguin")) {
                emperorCount++;
            } else if (penguin.equals("Little Penguin")) {
                littleCount++;
            } else if (penguin.equals("Macaroni Penguin")) {
                macaroniCount++;
            }
        }

        if (emperorCount > littleCount && emperorCount > macaroniCount) {
            System.out.println("Emperor Penguin");
        } else if (littleCount > emperorCount && littleCount > macaroniCount) {
            System.out.println("Little Penguin");
        } else {
            System.out.println("Macaroni Penguin");
        }

        scanner.close();
    }
}

