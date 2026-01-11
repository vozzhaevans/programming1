package Lr7.Example4;

public class FirstClass {
    public char symbol;

    public FirstClass(char symbol) {
        this.symbol = symbol;
    }

    public FirstClass copyFirstClass(char symbol) {
        FirstClass copyFirstClass = new FirstClass(symbol);
        copyFirstClass.symbol = this.symbol;
        return copyFirstClass;
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "symbol=" + symbol +
                '}';
    }
}
