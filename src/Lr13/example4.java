package Lr13;

public class example4 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);
        } catch (Exception e) {
            System.out.println("2 " + e); //добавлен вывод исключения
        } catch (Error e) {
            System.out.println("3 " + e);
        }
        System.out.println("4");
    }
}
