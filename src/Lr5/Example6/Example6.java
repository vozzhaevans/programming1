package Lr5.Example6;

public class Example6 {
    private int max = 0;
    private int min = 0;

    public Example6(int a, int b){
        setMaxMin(a, b);
    }
    public Example6(int a){
        setM(a);
    }
    public void setMaxMin (int a, int b) {
        if (a > b) {
            if (a > max){
                this.max = a;
            }
            if (b < min){
                this.min = b;
            }
        } else if (b > a) {
            if (b > max){
                this.max = b;
            }
            if (a < min){
                this.min = a;
            }
        }
    }

    public void setM (int a){
        if (a > max){
            this.max = a;
        } else if (a < min) {
            this.min = a;
        }
    }

    public void show(){
        System.out.println(max + ", " + min);
    }
}
