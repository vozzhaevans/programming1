package Lr6.Example3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Max: " + Example3.max(5, 12, 42, 2, 18, 81));
        System.out.println("Min: " + Example3.min(5, 12, 42, 2, 18, 81));
        System.out.println("Average: " +Example3.average(5, 12, 42, 2, 18, 81));

        System.out.println("Max: " + Example3.max(new int[] {16, 41, 4, 17, 55, 13}));
        System.out.println("Min: " + Example3.min(new int[] {16, 41, 4, 17, 55, 13}));
        System.out.println("Average: " +Example3.average(new int[] {16, 41, 4, 17, 55, 13}));

    }
}
