package Lr7.Example4;

class SecondClass extends FirstClass {
    public String text;

    public SecondClass(char symbol, String text) {
        super(symbol);
        this.text = text;
    }

    public SecondClass copySecondClass(char symbol, String text) {
        SecondClass copySecondClass = new SecondClass(symbol, text);
        copySecondClass.symbol = this.symbol;
        copySecondClass.text = this.text;
        return copySecondClass;
    }

    @Override
    public String toString() {
        return "SecondClass{" +
                "text='" + text + '\'' +
                "symbol= '" + symbol +'\'' +
                '}';
    }
}
