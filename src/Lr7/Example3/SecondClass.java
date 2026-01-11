package Lr7.Example3;

public class SecondClass extends FirstClass {
    public char character;

    public SecondClass(int number, char character) {
        super(number);
        this.character = character;
    }
    public void setValues(int number, char character) {
        this.number = number;
        this.character = character;
    }

    @Override
    public String toString() {
        return "SecondClass{number=" + number + ", character=" + character + "}";
    }
}
