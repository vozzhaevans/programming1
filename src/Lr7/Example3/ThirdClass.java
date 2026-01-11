package Lr7.Example3;

public class ThirdClass extends SecondClass {
    public String text;

    public ThirdClass(int number, char character, String text) {
        super(number, character);
        this.text = text;
    }
    public void setValues(int number, char character, String text) {
        this.number = number;
        this.character = character;
        this.text = text;
    }

    @Override
    public String toString() {
        return "ThirdClass{number=" + number + ", character=" + character + ", text='" + text + "'}";
    }
}
