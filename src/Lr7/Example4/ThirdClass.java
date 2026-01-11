package Lr7.Example4;

class ThirdClass extends SecondClass {
    public int number;

    public ThirdClass(char symbol, String text, int number) {
        super(symbol, text);
        this.number = number;
    }


    public ThirdClass copyThirdClass(char symbol, String text, int number) {
        ThirdClass copyThirdClass = new ThirdClass(symbol, text, number);
        copyThirdClass.symbol = this.symbol;
        copyThirdClass.text = this.text;
        copyThirdClass.number = this.number;
        return copyThirdClass;
    }

    @Override
    public String toString() {
        return "ThirdClass{" +
                "text='" + text + '\'' +
                "symbol= '" + symbol +'\'' +
                 "number= '" + number +'\'' +
                '}';
    }
}