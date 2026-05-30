package Lr13;

public class example7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException ex) {
                System.out.println("2 " + e);
            }
        }
        System.out.println("3");
    }

}
