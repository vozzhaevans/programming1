package Lr7.Example2;

public class SuperClass {
    private String text;

    public SuperClass(String text) {
        this.text = text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getTextLength() {
        return text.length();
    }
    public String getText() {
        return text;
    }
}
