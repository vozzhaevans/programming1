package Lr7.Example5;

public class SuperClass {
    private String text;

    public SuperClass(String text) {
        this.text = text;
    }

    public void displayInfo() {
        System.out.println("Класс: " + this.getClass().getSimpleName() + ", text: " + text);
    }

    protected String getText() {
        return text;
    }
}
