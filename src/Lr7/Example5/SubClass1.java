package Lr7.Example5;

class SubClass1 extends SuperClass {

    protected int number;

    public SubClass1(String text, int number) {
        super(text);
        this.number = number;
    }

    @Override
    public void displayInfo() {
        System.out.println("Класс: " + this.getClass().getSimpleName() +
                ", text: " + getText() + ", number: " + number);
    }
}