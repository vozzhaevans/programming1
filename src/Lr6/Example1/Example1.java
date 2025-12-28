package Lr6.Example1;

public class Example1 {
    private char a;
    private String b;

    public void setAb (char a) {
        this.a = a;
    }
    public void setAb (String b) {
        this.b = b;
    }
    public void setAb (char [] a) {
        this.b = "";
        if (a.length == 1) {
            this.a = a [0];
        } else {
            for (int i = 0; i < a.length ; i++) {
                this.b += a[i];
            }
        }

    }
    public void show () {
        System.out.println(a);
        System.out.println(b);
    }

}
