package Lr13;

public class example3 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);
        } catch (RuntimeException e) {
            System.out.println("2 " + e);  //добавлен вывод исключения
        } catch (Exception e) {
            System.out.println("3 " + e);
        }
        System.out.println("4");
    }
}
