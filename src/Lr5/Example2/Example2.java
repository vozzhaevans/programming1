package Lr5.Example2;

public class Example2 {

    private char a;
    private char b;

    public void setAB (char start, char end) {
        this.a = start;
        this.b = end;
    }

    public void getAB () {
        for (char i = a; i <= b; i++) {
            System.out.print(i + " ");

        }

    }

}
