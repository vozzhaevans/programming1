package Lr5.Example3;

public class Example3 {
    private int a;
    private int b;

    public Example3 () {
        this.a = 6;
        this.b = 4;
    }

    public Example3 (int a) {
        this.a = a;
        this.b = 4;
    }

    public Example3 (int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void showAB () {
        System.out.println(a + " и "+ b );
    }
}
