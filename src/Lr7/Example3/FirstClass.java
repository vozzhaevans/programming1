package Lr7.Example3;

public class FirstClass {
    public int number;

    public FirstClass(int number) {
        this.number = number;
    }

    public void setValues(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "number=" + number +
                '}';
    }
}
