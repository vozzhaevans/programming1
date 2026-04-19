package Lr11;

import java.util.List;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        String string = "Напишите функцию, Которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые имеют длину больше заданного значения.";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\n" + "Исходный список строк: " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        int minLength = 5;
        List<String> stringsAfter = filterStringsByMinLength(strings, minLength);

        System.out.println("\n" + "Строки длиной больше " + minLength + " символов: " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e + " (длина: " + e.length() + ")");
        }

    }

    private static List<String> filterStringsByMinLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}