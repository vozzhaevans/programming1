package Lr6.Example3;

public class Example3 {
    public static int max(int ... numbers){
        int maxValue = numbers[0];
        for (int num : numbers) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        return maxValue;
    }

    public static int min(int... numbers) {
        int minValue = numbers[0];
        for (int num : numbers) {
            if (num < minValue) {
                minValue = num;
            }
        }
        return minValue;
    }
    public static double average(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

}
