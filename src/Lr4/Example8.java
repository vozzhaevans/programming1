package Lr4;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        System.out.println("Введите ключ:");
        int key = scanner.nextInt();
        scanner.nextLine();

        String encryptedText = encryptLetters(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        boolean reverse = true;
        while (reverse) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                String decryptedText = decryptLetters(encryptedText, key);
                System.out.println("Обратное преобразование: " + decryptedText);
                reverse = false;
            } else if (answer.equals("n")) {
                System.out.println("До свидания!");
                reverse = false;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }

        scanner.close();
    }

    public static String encryptLetters(String text, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char encryptedChar = (char)('A' + (ch - 'A' + key) % 26);
                encrypted.append(encryptedChar);
            }
            else if (ch >= 'a' && ch <= 'z') {
                char encryptedChar = (char)('a' + (ch - 'a' + key) % 26);
                encrypted.append(encryptedChar);
            }
            else if (ch >= 'А' && ch <= 'Я') {
                char encryptedChar = (char)('А' + (ch - 'А' + key) % 32);
                encrypted.append(encryptedChar);
            }
            else if (ch >= 'а' && ch <= 'я') {
                char encryptedChar = (char)('а' + (ch - 'а' + key) % 32);
                encrypted.append(encryptedChar);
            }
            else {
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }

    public static String decryptLetters(String text, int key) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char decryptedChar = (char)('A' + (ch - 'A' - key + 26) % 26);
                decrypted.append(decryptedChar);
            }
            else if (ch >= 'a' && ch <= 'z') {
                char decryptedChar = (char)('a' + (ch - 'a' - key + 26) % 26);
                decrypted.append(decryptedChar);
            }
            else if (ch >= 'А' && ch <= 'Я') {
                char decryptedChar = (char)('А' + (ch - 'А' - key + 32) % 32);
                decrypted.append(decryptedChar);
            }
            else if (ch >= 'а' && ch <= 'я') {
                char decryptedChar = (char)('а' + (ch - 'а' - key + 32) % 32);
                decrypted.append(decryptedChar);
            }
            else {
                decrypted.append(ch);
            }
        }

        return decrypted.toString();
    }
}
