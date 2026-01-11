package Lr7.Example2;

public class SubClass extends SuperClass {

    public int number;

    public SubClass(String text, int number) {
        super(text);
        this.number = number;
    }
    public void setText() {
        this.setText("default");
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }
    public void setText(int number) {
        this.number = number;
        super.setText(String.valueOf(number));
    }
    public void setText(String text, int number) {
        super.setText(text);
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

}
