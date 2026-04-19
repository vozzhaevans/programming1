package Lr11;

import java.util.List;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        String string = "Напишите123 функцию, Которая принимает! на вход список " +
                "строк и возвращает~ новый список, Содержащий только5 те строки, " +
                "которые содержат00 только буквы (без цифр и символов). " ;

        List<String> strings = List.of(string.split(" "));

        System.out.println("\n" + "Исходный список строк: " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterOnlyLettersStrings(strings);

        System.out.println("\n" + "Строки, содержащие только буквы (без цифр и символов): " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }

    }

    private static List<String> filterOnlyLettersStrings(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("^[a-zA-Zа-яА-ЯёЁ]+$"))
                .collect(Collectors.toList());
    }

}