package Lr3;

public class Example7 {
    public static void main(String[] args) {

        int n = 10;
        char[] Array = new char[n];
        char b = 'a';

        for (int i = 0; i < Array.length; i++){
            Array[i] = b;
            b+=2;
            System.out.print(Array[i] + " ");
        }

        System.out.println();
        for (int i = Array.length - 1 ; i >= 0; i--){
            System.out.print(Array[i] + " ");
        }
    }
}