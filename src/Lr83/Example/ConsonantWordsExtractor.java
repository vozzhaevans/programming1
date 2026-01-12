package Lr83.Example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConsonantWordsExtractor {

    private static final String VOWELS = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";


    public static boolean isConsonant(char c) {
        if ((c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') || c == 'ё' || c == 'Ё') {
            return VOWELS.indexOf(c) == -1;
        }
        return false;
    }

    public static List<String> extractConsonantWords(String line) {
        List<String> consonantWords = new ArrayList<>();

        // Разбиваем строку на слова по пробелам и знакам препинания
        String[] words = line.split("[\\s\\p{Punct}]+");

        for (String word : words) {
            // Пропускаем пустые строки
            if (word.isEmpty()) {
                continue;
            }

            // Проверяем первый символ слова
            char firstChar = word.charAt(0);
            if (isConsonant(firstChar)) {
                consonantWords.add(word);
            }
        }

        return consonantWords;
    }

    public static void main(String[] args) {
        String sourceFile = "c:\\MyFile1.txt";
        String resultFile = "c:\\MyFile2.txt";

        try {
            processFile(sourceFile, resultFile);

            System.out.println("Обработка завершена!");
            System.out.println("Результат сохранен в файл: " + resultFile);

            System.out.println("\n=== Содержимое результирующего файла ===");
            printResultFile(resultFile);

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    private static void processFile(String sourceFile, String resultFile) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8)
        );

        PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(resultFile), StandardCharsets.UTF_8)
        );

        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;

            // Извлекаем слова, начинающиеся с согласных
            List<String> consonantWords = extractConsonantWords(line);

            // Если есть такие слова, записываем в результат
            if (!consonantWords.isEmpty()) {
                writer.println("Строка " + lineNumber + " (слов: " + consonantWords.size() + "):");
                for (String word : consonantWords) {
                    writer.println("  " + word);
                }
                writer.println(); // пустая строка для разделения
            }
        }

        reader.close();
        writer.close();
    }


    private static void printResultFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8)
        );

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}