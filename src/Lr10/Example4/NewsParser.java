package Lr10.Example4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsParser {

    private static final int MAX_RETRIES = 5;
    private static final int INITIAL_DELAY_MS = 2000;
    private static final String URL = "https://stopgame.ru/news";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36";

    public static void main(String[] args) {
        Document doc = null;
        int attempt = 0;
        int delay = INITIAL_DELAY_MS;

        while (attempt < MAX_RETRIES && doc == null) {
            attempt++;
            try {
                System.out.println("Попытка подключения #" + attempt + " к " + URL);

                doc = Jsoup.connect(URL)
                        .userAgent(USER_AGENT)
                        .timeout(15000) // Таймаут 15 секунд
                        .get();

                System.out.println("Подключение успешно установлено!");

            } catch (IOException e) {
                System.err.println("Ошибка при подключении (попытка " + attempt + "): " + e.getMessage());

                if (attempt < MAX_RETRIES) {
                    System.out.println("Повторная попытка через " + delay + " мс...");
                    try {
                        Thread.sleep(delay);
                        delay *= 2;
                    } catch (InterruptedException ie) {
                        System.err.println("Ожидание было прервано: " + ie.getMessage());
                        Thread.currentThread().interrupt();
                        break;
                    }
                } else {
                    System.err.println("Не удалось подключиться после " + MAX_RETRIES + " попыток.");
                    System.err.println("Проверьте подключение к интернету и доступность сайта " + URL);
                }
            }
        }

        if (doc == null) {
            System.err.println("Программа завершена из-за невозможности подключиться к сайту.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String fileName = "news_" + timestamp + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, false))) {

            Elements articles = doc.select("article[aria-label]");

            if (articles.isEmpty()) {
                String errorMsg = "Новости не найдены. Возможно, сайт изменил структуру страницы.";
                System.err.println(errorMsg);
                writer.println(errorMsg);
                writer.println("Дата попытки: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
                System.out.println("Данные не сохранены - новости не найдены.");
                return;
            }

            writer.println("Новости с сайта StopGame.ru");
            writer.println("Дата парсинга: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
            writer.println("=".repeat(70));
            writer.println();

            int newsCount = 0;

            for (int i = 0; i < articles.size() && i < 20; i++) {
                try {
                    Element article = articles.get(i);

                    String ariaLabel = article.attr("aria-label");
                    String title = ariaLabel.replace("Новость: ", "");

                    Element dateElement = article.select("time, .date, [class*='date'], [class*='time']").first();
                    String date = "";

                    if (dateElement != null) {
                        date = dateElement.text();
                    } else {
                        String articleText = article.text();
                        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(\\d{1,2}\\s+\\w+|Вчера|Сегодня|\\d{2}:\\d{2})");
                        java.util.regex.Matcher matcher = pattern.matcher(articleText);
                        if (matcher.find()) {
                            date = matcher.group();
                        } else {
                            date = "дата не указана";
                        }
                    }

                    System.out.println("Тема : " + title);
                    System.out.println("Дата : " + date);
                    System.out.println();

                    writer.println("Новость #" + (i + 1));
                    writer.println("Тема : " + title);
                    writer.println("Дата : " + date);
                    writer.println("-".repeat(50));
                    writer.println();

                    newsCount++;

                } catch (Exception e) {
                    System.err.println("Ошибка при обработке новости #" + (i + 1) + ": " + e.getMessage());
                    writer.println("Ошибка при обработке новости #" + (i + 1) + ": " + e.getMessage());
                }
            }

            String summary = "Всего сохранено новостей: " + newsCount;
            System.out.println(summary);
            writer.println(summary);
            writer.println("Файл сохранен: " + fileName);

            System.out.println("Данные сохранены в файл: " + fileName);
            System.out.println("Путь к файлу: " + new File(fileName).getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            System.err.println("Возможно, нет прав на запись в текущую директорию.");
            e.printStackTrace();
        }
    }
}