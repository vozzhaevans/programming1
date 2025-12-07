package Lr3;

public class Example8 {
    public static void main(String[] args) {

        char[] ABC = new char[10];

        char a = 'A';
        int i = 0;

        while (i < 10) {
            if (a != 'A' && a != 'E' && a != 'I'
                    && a != 'O' && a != 'U' && a != 'Y') {
                ABC [i] = a;
                i++;
            }
            a++;
        }

        System.out.println("Массив из 10 согласных букв:");
        for (int j = 0; j < ABC.length; j++) {
            System.out.print(ABC[j] + " ");
        }
    }
}
