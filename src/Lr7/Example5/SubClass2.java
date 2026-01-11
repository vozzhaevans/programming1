package Lr7.Example5;

class SubClass2 extends SuperClass {

    protected char symbol;

    public SubClass2(String text, char symbol) {
        super(text);
        this.symbol = symbol;
    }

    @Override
    public void displayInfo() {
        System.out.println("Класс: " + this.getClass().getSimpleName() +
                ", text: " + getText() + ", symbol: " + symbol);
    }
}