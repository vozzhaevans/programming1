package Lr6.Example9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        char[] arrayEx = {'п', 'р', 'и', 'в', 'е', 'т'};
        System.out.println(Arrays.toString(getElements(arrayEx)));
    }
    public static char[] getElements (char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            // Обмен значениями через временную переменную
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Двигаем индексы навстречу друг другу
            left++;
            right--;
        }
        return chars;
    }

}
