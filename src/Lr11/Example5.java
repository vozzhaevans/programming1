package Lr11;

import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        String text = "Напишите функцию, Которая принимает на вход список " +
                "строк и возвращает новый список, Содержащий только те строки, " +
                "которые содержат заданную подстроку.";

        List<String> strings = List.of(text.split(" "));

        System.out.println("\n" + "Исходный список строк: " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        String substring = "список";
        List<String> stringsAfter = filterStringsBySubstring(strings, substring);

        System.out.println("\n" + "Строки, содержащие подстроку \"" + substring + "\": " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }

    }

    private static List<String> filterStringsBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}