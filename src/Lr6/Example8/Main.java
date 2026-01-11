package Lr6.Example8;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("среднее значение массива: " + getMedium(array));
    }

    public static double getMedium(int[] arrayInt) {
        int sum = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            int value = arrayInt[i];
            sum += value;
        }
        return (double) sum/arrayInt.length;
    }
}
