package Lr5.Example4;

public class Example4 {
    private char a;
    private int b;

    public Example4 (char symbol, int number) {
        this.a = symbol;
        this.b = number;
    }
    public  void showAB(){
        System.out.println("символ: "  + a + " число: " + b);
    }

    public Example4 (double c) {
        int charCode = (int) c;
        this.a = (char) charCode;

        double fractionalPart = c - charCode;
        int twoDigitFraction = (int) (fractionalPart * 100);
        this.b = twoDigitFraction;

        System.out.println("дробь: " + c + " символ: "  + a + " код символа: " + charCode + " число: " + b);
    }
}
