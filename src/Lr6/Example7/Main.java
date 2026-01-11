package Lr6.Example7;

public class Main {
    public static void main(String[] args) {
        char[] characters = {'п', 'р', 'и', 'в', 'е', 'т'};

        int[] codes = getArray(characters);

        // Выводим результат
        System.out.print("Символы: ");
        for (char c : characters) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("Коды:    ");
        for (int code : codes) {
            System.out.print(code + " ");
        }
        System.out.println();
    }

    public static int[] getArray(char[] chars){
        int[] codes = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            codes[i] = (int) chars[i];
        }

        return codes;
    }

}
