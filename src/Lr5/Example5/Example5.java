package Lr5.Example5;

public class Example5 {
    private int a;

    public  Example5(){
        setA();
    }
    public Example5(int a){
        setA(a);
    }

    public void setA (int a) {
       if (a < 100) {
           this.a = a;
       } else {
           this.a = 100;
       }

    }
    public void setA () {
        this.a = 0;
    }

    public void showA(){
        System.out.println(a);
    }

}
