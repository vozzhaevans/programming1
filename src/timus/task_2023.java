package timus;

import java.util.Scanner;

public class task_2023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        int currentPosition = 1; // Начинаем у первого шкафа (слева)
        int totalSteps = 0;

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine().trim();
            char firstLetter = name.charAt(0);

            // Определяем, в какой шкаф нужно положить письмо
            int targetPosition = getTargetPosition(firstLetter);

            // Считаем шаги от текущей позиции до целевой
            int steps = Math.abs(targetPosition - currentPosition);
            totalSteps += steps;

            // Перемещаемся к целевому шкафу
            currentPosition = targetPosition;
        }

        System.out.println(totalSteps);
        scanner.close();
    }

    // Метод для определения номера шкафа по первой букве имени
    private static int getTargetPosition(char firstLetter) {
        // Шкаф 1: A, P, O, R
        if (firstLetter == 'A' || firstLetter == 'P' ||
                firstLetter == 'O' || firstLetter == 'R') {
            return 1;
        }
        // Шкаф 2: B, M, S
        else if (firstLetter == 'B' || firstLetter == 'M' ||
                firstLetter == 'S') {
            return 2;
        }
        // Шкаф 3: D, G, J, K, T, W
        else if (firstLetter == 'D' || firstLetter == 'G' ||
                firstLetter == 'J' || firstLetter == 'K' ||
                firstLetter == 'T' || firstLetter == 'W') {
            return 3;
        }
        // На всякий случай, если пришло письмо с другой буквой
        return 1;
    }
}