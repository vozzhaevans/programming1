package Lr10.Example2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XmlParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            File inputFile = new File("src/Lr10/Example2/example_task.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            while (true) {
                System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
                System.out.println("1. Показать все задачи");
                System.out.println("2. Добавить новую задачу");
                System.out.println("3. Поиск задач");
                System.out.println("4. Удалить задачу");
                System.out.println("5. Выйти из программы");
                System.out.print("Выберите действие (1-5): ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        showAllTasks(doc);
                        break;
                    case "2":
                        doc = addNewTask(doc, scanner, inputFile);
                        break;
                    case "3":
                        searchTasks(doc, scanner);
                        break;
                    case "4":
                        doc = deleteTask(doc, scanner, inputFile);
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

    private static void showAllTasks(Document doc) {
        System.out.println("\nВСЕ ЗАДАЧИ");
        NodeList nodeList = doc.getElementsByTagName("task");

        if (nodeList.getLength() == 0) {
            System.out.println("Задачи не найдены.");
            return;
        }

        System.out.println("Всего задач: " + nodeList.getLength());

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                printTaskInfo(element, i + 1);
            }
        }
    }

    private static Document addNewTask(Document doc, Scanner scanner, File inputFile) {
        try {
            System.out.println("\nДОБАВЛЕНИЕ НОВОЙ ЗАДАЧИ");

            Element root = doc.getDocumentElement();

            Element newTask = doc.createElement("task");

            System.out.print("Введите название задачи: ");
            String title = scanner.nextLine();

            System.out.print("Введите имя исполнителя: ");
            String implementer = scanner.nextLine();

            System.out.print("Введите дедлайн (например, 2024-12-31): ");
            String deadlines = scanner.nextLine();

            Element titleElement = doc.createElement("title");
            titleElement.appendChild(doc.createTextNode(title));
            newTask.appendChild(titleElement);

            Element implementerElement = doc.createElement("implementer");
            implementerElement.appendChild(doc.createTextNode(implementer));
            newTask.appendChild(implementerElement);

            Element deadlinesElement = doc.createElement("deadlines");
            deadlinesElement.appendChild(doc.createTextNode(deadlines));
            newTask.appendChild(deadlinesElement);

            root.appendChild(newTask);

            saveToFile(doc, inputFile);

            System.out.println("\nНовая задача успешно добавлена!");

            return reloadDocument(inputFile);

        } catch (Exception e) {
            System.out.println("Ошибка при добавлении задачи: " + e.getMessage());
            e.printStackTrace();
            return doc;
        }
    }

    private static Document deleteTask(Document doc, Scanner scanner, File inputFile) {
        try {
            System.out.println("\nУДАЛЕНИЕ ЗАДАЧИ");
            System.out.println("Выберите способ удаления:");
            System.out.println("1. Удалить по названию");
            System.out.println("2. Удалить по номеру");
            System.out.println("3. Удалить все задачи");
            System.out.print("Ваш выбор (1-3): ");

            String deleteChoice = scanner.nextLine();

            switch (deleteChoice) {
                case "1":
                    deleteByTitle(doc, scanner, inputFile);
                    break;
                case "2":
                    deleteByNumber(doc, scanner, inputFile);
                    break;
                case "3":
                    deleteAllTasks(doc, scanner, inputFile);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }

            return reloadDocument(inputFile);

        } catch (Exception e) {
            System.out.println("Ошибка при удалении задачи: " + e.getMessage());
            e.printStackTrace();
            return doc;
        }
    }

    private static void deleteByTitle(Document doc, Scanner scanner, File inputFile) {
        try {
            System.out.print("\nВведите название задачи для удаления (или его часть): ");
            String searchTitle = scanner.nextLine().toLowerCase();

            NodeList nodeList = doc.getElementsByTagName("task");
            boolean found = false;
            int count = 0;

            System.out.println("\nНайдены следующие задачи:");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Node titleNode = element.getElementsByTagName("title").item(0);
                    if (titleNode != null && titleNode.getTextContent().toLowerCase().contains(searchTitle)) {
                        printTaskInfo(element, ++count);
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("Задачи с названием \"" + searchTitle + "\" не найдены.");
                return;
            }

            System.out.print("\nУдалить все найденные задачи? (да/нет): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("да")) {
                NodeList updatedNodeList = doc.getElementsByTagName("task");
                for (int i = updatedNodeList.getLength() - 1; i >= 0; i--) {
                    Node node = updatedNodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        Node titleNode = element.getElementsByTagName("title").item(0);
                        if (titleNode != null && titleNode.getTextContent().toLowerCase().contains(searchTitle)) {
                            node.getParentNode().removeChild(node);
                        }
                    }
                }

                saveToFile(doc, inputFile);
                System.out.println("\nУдалено " + count + " задача(и).");
            } else {
                System.out.println("Удаление отменено.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при удалении: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteByNumber(Document doc, Scanner scanner, File inputFile) {
        try {
            NodeList nodeList = doc.getElementsByTagName("task");

            if (nodeList.getLength() == 0) {
                System.out.println("Нет задач для удаления.");
                return;
            }

            System.out.println("\nТекущий список задач:");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.print((i + 1) + ". ");
                    Node titleNode = element.getElementsByTagName("title").item(0);
                    String title = (titleNode != null) ? titleNode.getTextContent() : "Без названия";
                    System.out.println(title);
                }
            }

            System.out.print("\nВведите номер задачи для удаления (1-" + nodeList.getLength() + "): ");
            try {
                int taskNumber = Integer.parseInt(scanner.nextLine());

                if (taskNumber >= 1 && taskNumber <= nodeList.getLength()) {
                    Node taskToDelete = nodeList.item(taskNumber - 1);
                    String taskTitle = "";
                    if (taskToDelete.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) taskToDelete;
                        Node titleNode = element.getElementsByTagName("title").item(0);
                        taskTitle = (titleNode != null) ? titleNode.getTextContent() : "Без названия";
                    }

                    System.out.print("Удалить задачу \"" + taskTitle + "\"? (да/нет): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("да")) {
                        taskToDelete.getParentNode().removeChild(taskToDelete);
                        saveToFile(doc, inputFile);
                        System.out.println("\nЗадача \"" + taskTitle + "\" успешно удалена!");
                    } else {
                        System.out.println("Удаление отменено.");
                    }
                } else {
                    System.out.println("Неверный номер задачи!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при удалении: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteAllTasks(Document doc, Scanner scanner, File inputFile) {
        try {
            NodeList nodeList = doc.getElementsByTagName("task");

            if (nodeList.getLength() == 0) {
                System.out.println("Нет задач для удаления.");
                return;
            }

            System.out.println("\nВНИМАНИЕ! Вы собираетесь удалить ВСЕ задачи (" + nodeList.getLength() + " шт.)");
            System.out.print("Для подтверждения введите 'УДАЛИТЬ ВСЕ': ");
            String confirm = scanner.nextLine();

            if (confirm.equals("УДАЛИТЬ ВСЕ")) {
                for (int i = nodeList.getLength() - 1; i >= 0; i--) {
                    Node node = nodeList.item(i);
                    node.getParentNode().removeChild(node);
                }

                saveToFile(doc, inputFile);
                System.out.println("\n✅ Все задачи успешно удалены!");
            } else {
                System.out.println("Удаление отменено.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при удалении: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void searchTasks(Document doc, Scanner scanner) {
        System.out.println("\nПОИСК ЗАДАЧ");
        System.out.println("1. Поиск по исполнителю");
        System.out.println("2. Поиск по дедлайну");
        System.out.println("3. Поиск по названию");
        System.out.print("Выберите тип поиска (1-3): ");

        String searchType = scanner.nextLine();

        switch (searchType) {
            case "1":
                searchByImplementer(doc, scanner);
                break;
            case "2":
                searchByDeadline(doc, scanner);
                break;
            case "3":
                searchByTitle(doc, scanner);
                break;
            default:
                System.out.println("Неверный выбор поиска!");
        }
    }

    private static void searchByImplementer(Document doc, Scanner scanner) {
        System.out.print("\nВведите имя исполнителя (или его часть): ");
        String searchImplementer = scanner.nextLine().toLowerCase();

        NodeList nodeList = doc.getElementsByTagName("task");
        boolean found = false;
        int count = 0;

        System.out.println("\nРЕЗУЛЬТАТЫ ПОИСКА ПО ИСПОЛНИТЕЛЮ: \"" + searchImplementer + "\" ===");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                Node implementerNode = element.getElementsByTagName("implementer").item(0);
                if (implementerNode != null) {
                    String implementer = implementerNode.getTextContent().toLowerCase();

                    if (implementer.contains(searchImplementer)) {
                        printTaskInfo(element, ++count);
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("Задачи с исполнителем \"" + searchImplementer + "\" не найдены.");
        } else {
            System.out.println("\nВсего найдено задач: " + count);
        }
    }

    private static void searchByDeadline(Document doc, Scanner scanner) {
        System.out.print("\nВведите дедлайн (например, 2024-12-31 или часть даты): ");
        String searchDeadline = scanner.nextLine().toLowerCase();

        NodeList nodeList = doc.getElementsByTagName("task");
        boolean found = false;
        int count = 0;

        System.out.println("\nРЕЗУЛЬТАТЫ ПОИСКА ПО ДЕДЛАЙНУ: \"" + searchDeadline + "\" ===");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                Node deadlineNode = element.getElementsByTagName("deadlines").item(0);
                if (deadlineNode != null) {
                    String deadline = deadlineNode.getTextContent().toLowerCase();

                    if (deadline.contains(searchDeadline)) {
                        printTaskInfo(element, ++count);
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("Задачи с дедлайном \"" + searchDeadline + "\" не найдены.");
        } else {
            System.out.println("\nВсего найдено задач: " + count);
        }
    }

    private static void searchByTitle(Document doc, Scanner scanner) {
        System.out.print("\nВведите название задачи (или его часть): ");
        String searchTitle = scanner.nextLine().toLowerCase();

        NodeList nodeList = doc.getElementsByTagName("task");
        boolean found = false;
        int count = 0;

        System.out.println("\nРЕЗУЛЬТАТЫ ПОИСКА ПО НАЗВАНИЮ: \"" + searchTitle + "\" ===");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                Node titleNode = element.getElementsByTagName("title").item(0);
                if (titleNode != null) {
                    String title = titleNode.getTextContent().toLowerCase();

                    if (title.contains(searchTitle)) {
                        printTaskInfo(element, ++count);
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("Задачи с названием \"" + searchTitle + "\" не найдены.");
        } else {
            System.out.println("\nВсего найдено задач: " + count);
        }
    }

    private static void printTaskInfo(Element element, int number) {
        Node titleNode = element.getElementsByTagName("title").item(0);
        Node implementerNode = element.getElementsByTagName("implementer").item(0);
        Node deadlinesNode = element.getElementsByTagName("deadlines").item(0);

        String title = (titleNode != null) ? titleNode.getTextContent() : "Не указано";
        String implementer = (implementerNode != null) ? implementerNode.getTextContent() : "Не указан";
        String deadlines = (deadlinesNode != null) ? deadlinesNode.getTextContent() : "Не указан";

        System.out.println("\nЗадача #" + number);
        System.out.println("   Название: " + title);
        System.out.println("   Исполнитель: " + implementer);
        System.out.println("   Дедлайн: " + deadlines);
        System.out.println("   " + "-".repeat(30));
    }

    private static void saveToFile(Document doc, File inputFile) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(inputFile);
            transformer.transform(source, result);
        } catch (TransformerException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Document reloadDocument(File inputFile) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        return doc;
    }
}