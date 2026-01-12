package Lr82.Example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class  FileProcessorDataStreams {

    public static void main(String[] args) {
        String sourcePath = "c:\\MyFile1.txt";
        String resultPath = "c:\\MyFile2.txt";

        try {
            File f1 = new File(sourcePath);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f1), StandardCharsets.UTF_8)
            );

            String firstLine = reader.readLine();   // игнорируем
            String secondLine = reader.readLine();  // сохраняем
            String numbersLine = reader.readLine(); // обрабатываем

            reader.close();

            // Парсим числа и фильтруем положительные
            String[] numStrs = numbersLine.trim().split("\\s+");
            StringBuilder positiveNumbers = new StringBuilder();
            for (String numStr : numStrs) {
                double num = Double.parseDouble(numStr);
                if (num > 0) {
                    if (positiveNumbers.length() > 0) {
                        positiveNumbers.append(" ");
                    }
                    positiveNumbers.append(num);
                }
            }

            // Записываем результат в текстовый файл (UTF-8)
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(resultPath), StandardCharsets.UTF_8)
            );

            writer.println(secondLine);           // вторая строка
            writer.println(positiveNumbers);      // положительные числа через пробел

            writer.close();

            System.out.println("Результирующий файл создан: " + resultPath);

            // Показываем содержимое результата
            System.out.println("\n=== Содержимое результирующего файла ===");
            BufferedReader resultReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(resultPath), StandardCharsets.UTF_8)
            );
            String line;
            while ((line = resultReader.readLine()) != null) {
                System.out.println(line);
            }
            resultReader.close();

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

}