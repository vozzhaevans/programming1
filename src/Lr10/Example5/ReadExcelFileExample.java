package Lr10.Example5;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import java.util.Scanner;

public class ReadExcelFileExample {

    private static final Scanner scanner = new Scanner(System.in);
    private static String filePath = "src/Lr10/Example5/example.xlsx";

    public static void main(String[] args) {
        boolean success = false;

        System.out.println("Программа для чтения Excel файлов");
        System.out.println("Путь по умолчанию: " + filePath);
        System.out.print("Введите путь к Excel файлу (или нажмите Enter для использования пути по умолчанию): ");
        String userInputPath = scanner.nextLine().trim();

        if (!userInputPath.isEmpty()) {
            filePath = userInputPath;
        }

        while (!success) {
            try {
                executeExcelReading();
                success = true;

            } catch (FileNotFoundException e) {
                System.err.println("\nОШИБКА: Файл не найден!");
                System.err.println("   Причина: " + e.getMessage());
                System.err.println("\nРекомендации:");
                System.err.println("   1. Проверьте, существует ли файл по указанному пути: " + filePath);
                System.err.println("   2. Убедитесь, что путь к файлу указан правильно");
                System.err.println("   3. Проверьте, есть ли у вас права на чтение файла");

                if (!askForRetry()) {
                    break;
                }

            } catch (OLE2NotOfficeXmlFileException | NotOLE2FileException e) {
                System.err.println("\nОШИБКА: Неверный формат файла!");
                System.err.println("   Причина: Файл не является корректным Excel файлом (.xlsx формата)");
                System.err.println("\nРекомендации:");
                System.err.println("   1. Убедитесь, что файл имеет расширение .xlsx");
                System.err.println("   2. Проверьте, что файл не поврежден");
                System.err.println("   3. Откройте файл в Excel и сохраните его заново");
                System.err.println("   4. Для файлов .xls используйте HSSFWorkbook вместо XSSFWorkbook");

                if (!askForRetry()) {
                    break;
                }

            } catch (NullPointerException e) {
                System.err.println("\nОШИБКА: Запрашиваемый лист не найден!");
                System.err.println("   Причина: " + e.getMessage());
                System.err.println("\nРекомендации:");
                System.err.println("   1. Проверьте правильность написания имени листа");
                System.err.println("   2. Имя листа чувствительно к регистру");
                System.err.println("   3. Доступные листы в файле:");
                try {
                    showAvailableSheets();
                } catch (Exception ex) {
                    System.err.println("      Не удалось получить список листов");
                }

                if (!askForRetry()) {
                    break;
                }

            } catch (IOException e) {
                System.err.println("\nОШИБКА ВВОДА-ВЫВОДА!");
                System.err.println("   Причина: " + e.getMessage());
                System.err.println("\nРекомендации:");
                System.err.println("   1. Проверьте, не открыт ли файл в другой программе");
                System.err.println("   2. Убедитесь, что у вас есть права на чтение файла");
                System.err.println("   3. Проверьте, достаточно ли места на диске");
                System.err.println("   4. Попробуйте скопировать файл в другую директорию");

                if (!askForRetry()) {
                    break;
                }

            } catch (Exception e) {
                System.err.println("\nНЕПРЕДВИДЕННАЯ ОШИБКА!");
                System.err.println("   Тип ошибки: " + e.getClass().getSimpleName());
                System.err.println("   Сообщение: " + e.getMessage());
                System.err.println("\nРекомендации:");
                System.err.println("   1. Проверьте целостность файла Excel");
                System.err.println("   2. Убедитесь, что все необходимые библиотеки подключены");
                System.err.println("   3. Попробуйте создать новый файл Excel");
                System.err.println("   4. Детали ошибки для разработчика:");
                e.printStackTrace();

                if (!askForRetry()) {
                    break;
                }
            }
        }

        System.out.println("\nПрограмма завершена.");
        scanner.close();
    }

    private static void executeExcelReading() throws IOException {
        System.out.println("\n📖 Начинаю чтение файла: " + filePath);

        try (FileInputStream inputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            System.out.println("Файл успешно открыт");

            showAvailableSheets(workbook);

            String sheetName = askForSheetName(workbook);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new NullPointerException("Лист '" + sheetName + "' не найден в файле");
            }

            System.out.println("Лист '" + sheetName + "' найден");
            System.out.println("\nСодержимое таблицы:\n");

            int rowCount = 0;
            int cellCount = 0;

            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = getCellValueAsString(cell);
                    System.out.print(cellValue + "\t");
                    cellCount++;
                }
                System.out.println();
                rowCount++;
            }

            System.out.println("\nСтатистика:");
            System.out.println("   - Всего строк: " + rowCount);
            System.out.println("   - Всего ячеек: " + cellCount);
            System.out.println("Чтение файла успешно завершено!");
        }
    }

    private static String askForSheetName(XSSFWorkbook workbook) {
        System.out.println("\nДоступные листы в файле:");
        int numberOfSheets = workbook.getNumberOfSheets();

        for (int i = 0; i < numberOfSheets; i++) {
            String sheetName = workbook.getSheetName(i);
            System.out.println("   " + (i + 1) + ". " + sheetName);
        }

        System.out.print("\nВведите имя листа для чтения: ");
        String sheetName = scanner.nextLine().trim();

        // Проверка на пустой ввод
        while (sheetName.isEmpty()) {
            System.out.print("Имя листа не может быть пустым. Введите имя листа: ");
            sheetName = scanner.nextLine().trim();
        }

        return sheetName;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    double numericValue = cell.getNumericCellValue();
                    if (numericValue == (long) numericValue) {
                        return String.valueOf((long) numericValue);
                    } else {
                        return String.valueOf(numericValue);
                    }
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (IllegalStateException e) {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BLANK:
                return "";
            default:
                return "";
        }
    }

    private static void showAvailableSheets() throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            showAvailableSheets(workbook);
        }
    }

    private static void showAvailableSheets(XSSFWorkbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        System.out.println("      Всего листов в файле: " + numberOfSheets);

        for (int i = 0; i < numberOfSheets; i++) {
            String sheetName = workbook.getSheetName(i);
            System.out.println("      - " + sheetName);
        }
    }

    private static boolean askForRetry() {
        System.out.print("\nХотите попробовать снова после исправления ошибки? (да/нет): ");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("да") || answer.equals("д") || answer.equals("yes") || answer.equals("y")) {
            System.out.print("✏Хотите изменить путь к файлу? (да/нет): ");
            String changePath = scanner.nextLine().trim().toLowerCase();

            if (changePath.equals("да") || changePath.equals("д") || changePath.equals("yes") || changePath.equals("y")) {
                System.out.print("Введите новый путь к Excel файлу: ");
                String newPath = scanner.nextLine().trim();
                if (!newPath.isEmpty()) {
                    filePath = newPath;
                }
            }

            System.out.println("Повторный запуск программы...");
            return true;
        } else {
            System.out.println("Программа завершена по запросу пользователя.");
            return false;
        }
    }
}