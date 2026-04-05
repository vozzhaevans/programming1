package Lr10.Example3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonParser {
    private static final String FILE_PATH = "src/Lr10/Example3/task.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            JSONArray jsonArray = loadJsonData();

            System.out.println("Корневой элемент: task");
            System.out.println("Всего задач в файле: " + jsonArray.size());

            while (true) {
                System.out.println("\nГЛАВНОЕ МЕНЮ");
                System.out.println("1. Показать все задачи");
                System.out.println("2. Добавить новую задачу");
                System.out.println("3. Поиск по исполнителю");
                System.out.println("4. Удалить задачу");
                System.out.println("5. Выйти из программы");
                System.out.print("Выберите действие (1-5): ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        showAllTasks(jsonArray);
                        break;
                    case "2":
                        jsonArray = addNewTask(jsonArray, scanner);
                        break;
                    case "3":
                        searchByImplementer(jsonArray, scanner);
                        break;
                    case "4":
                        jsonArray = deleteTaskByTitle(jsonArray, scanner);
                        break;
                    case "5":
                        System.out.println("Программа завершена. До свидания!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный выбор! Пожалуйста, выберите 1-5.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONArray loadJsonData() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(FILE_PATH));
        JSONObject jsonObject = (JSONObject) obj;
        return (JSONArray) jsonObject.get("task");
    }

    private static void saveJsonData(JSONArray jsonArray) {
        try {
            JSONObject rootObject = new JSONObject();
            rootObject.put("task", jsonArray);

            try (FileWriter file = new FileWriter(FILE_PATH)) {
                file.write(rootObject.toJSONString());
                file.flush();
            }
            System.out.println("Данные успешно сохранены в файл!");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static JSONArray addNewTask(JSONArray jsonArray, Scanner scanner) {
        System.out.println("\nДОБАВЛЕНИЕ НОВОЙ ЗАДАЧИ");

        System.out.print("Введите название задачи: ");
        String title = scanner.nextLine();

        System.out.print("Введите имя исполнителя: ");
        String implementer = scanner.nextLine();

        System.out.print("Введите дедлайн (например, 2024.12.31 или 2024): ");
        String deadlines = scanner.nextLine();

        JSONObject newTask = new JSONObject();
        newTask.put("title", title);
        newTask.put("implementer", implementer);
        newTask.put("deadlines", deadlines);

        jsonArray.add(newTask);

        saveJsonData(jsonArray);

        System.out.println("\nНовая задача успешно добавлена!");
        System.out.println("Теперь всего задач: " + jsonArray.size());

        System.out.println("\nДобавленная задача:");
        printTaskInfo(newTask, jsonArray.size());

        return jsonArray;
    }

    private static JSONArray deleteTaskByTitle(JSONArray jsonArray, Scanner scanner) {
        System.out.println("\nУДАЛЕНИЕ ЗАДАЧИ");

        if (jsonArray.isEmpty()) {
            System.out.println("Нет задач для удаления.");
            return jsonArray;
        }

        System.out.println("\nТекущий список задач:");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject task = (JSONObject) jsonArray.get(i);
            String title = (String) task.get("title");
            System.out.println((i + 1) + ". " + title);
        }

        System.out.print("\nВведите название задачи для удаления (или его часть): ");
        String searchTitle = scanner.nextLine().toLowerCase();

        JSONArray toDelete = new JSONArray();
        for (Object obj : jsonArray) {
            JSONObject task = (JSONObject) obj;
            String title = (String) task.get("title");
            if (title != null && title.toLowerCase().contains(searchTitle)) {
                toDelete.add(task);
            }
        }

        if (toDelete.isEmpty()) {
            System.out.println("Задачи с названием \"" + searchTitle + "\" не найдены.");
            return jsonArray;
        }

        System.out.println("\nНайдены следующие задачи:");
        for (int i = 0; i < toDelete.size(); i++) {
            JSONObject task = (JSONObject) toDelete.get(i);
            printTaskInfo(task, i + 1);
        }

        System.out.print("\nУдалить найденные задачи? (да/нет): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("да")) {
            jsonArray.removeAll(toDelete);

            saveJsonData(jsonArray);

            System.out.println("\nУдалено " + toDelete.size() + " задача(и).");
            System.out.println("Теперь всего задач: " + jsonArray.size());
        } else {
            System.out.println("Удаление отменено.");
        }

        return jsonArray;
    }

    private static void showAllTasks(JSONArray jsonArray) {
        System.out.println("\nВСЕ ЗАДАЧИ");

        if (jsonArray.isEmpty()) {
            System.out.println("Задачи не найдены.");
            return;
        }

        System.out.println("Всего задач: " + jsonArray.size());

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject task = (JSONObject) jsonArray.get(i);
            printTaskInfo(task, i + 1);
        }
    }

    private static void searchByImplementer(JSONArray jsonArray, Scanner scanner) {
        System.out.print("\nВведите имя исполнителя (или его часть): ");
        String searchImplementer = scanner.nextLine().toLowerCase();

        boolean found = false;
        int count = 0;

        System.out.println("\nРЕЗУЛЬТАТЫ ПОИСКА ПО ИСПОЛНИТЕЛЮ: \"" + searchImplementer + "\" ===");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject task = (JSONObject) jsonArray.get(i);
            String implementer = (String) task.get("implementer");

            if (implementer != null && implementer.toLowerCase().contains(searchImplementer)) {
                printTaskInfo(task, ++count);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Задачи с исполнителем \"" + searchImplementer + "\" не найдены.");
        } else {
            System.out.println("\nВсего найдено задач: " + count);
        }
    }

    private static void printTaskInfo(JSONObject task, int number) {
        String title = (String) task.get("title");
        String implementer = (String) task.get("implementer");
        String deadlines = (String) task.get("deadlines");

        System.out.println("\nЗадача #" + number);
        System.out.println("Название: " + (title != null ? title : "Не указано"));
        System.out.println("Исполнитель: " + (implementer != null ? implementer : "Не указан"));
        System.out.println("Дедлайн: " + (deadlines != null ? deadlines : "Не указан"));
        System.out.println("   " + "-".repeat(35));
    }
}