package Lr13.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class example3 {
            public static byte addWithOverflowCheck(byte a, byte b) throws ArithmeticException {
                int sum = a + b;
                if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Переполнение: сумма " + sum + " выходит за пределы типа byte ("
                            + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + ")");
                }
                return (byte) sum;
            }

            public static byte calculateSum(byte[] array) throws ArithmeticException {
                byte sum = 0;
                for (int i = 0; i < array.length; i++) {
                    sum = addWithOverflowCheck(sum, array[i]);
                }
                return sum;
            }

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                boolean success = false;
                byte[] array = null;
                byte sum = 0;

                System.out.println("ПРОГРАММА ВЫЧИСЛЕНИЯ СУММЫ ЭЛЕМЕНТОВ МАССИВА (тип byte)\n");

                try {
                    System.out.print("Введите размер массива: ");
                    int size = 0;

                    try {
                        size = scanner.nextInt();
                        if (size <= 0) {
                            System.out.println("Размер массива должен быть положительным. Установлено значение по умолчанию: 3");
                            size = 3;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ОШИБКА: Введено нечисловое значение для размера. Установлен размер по умолчанию: 3");
                        scanner.next();
                        size = 3;
                    }

                    array = new byte[size];

                    System.out.println("\nВведите элементы массива (каждый элемент должен быть в диапазоне от "
                            + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + "):");

                    for (int i = 0; i < size; i++) {
                        while (true) {
                            try {
                                System.out.print("array[" + i + "] = ");
                                int input = scanner.nextInt();

                                if (input < Byte.MIN_VALUE || input > Byte.MAX_VALUE) {
                                    System.out.println("ОШИБКА: Число " + input + " выходит за пределы типа byte!");
                                    System.out.println("Допустимый диапазон: от " + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE);
                                    continue;
                                }

                                array[i] = (byte) input;
                                break;

                            } catch (InputMismatchException e) {
                                System.out.println("ОШИБКА (InputMismatchException): Введена строка вместо числа!");
                                scanner.next();
                            }
                        }
                    }

                    System.out.print("\nВведённый массив типа byte: [");
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i]);
                        if (i < array.length - 1) System.out.print(", ");
                    }
                    System.out.println("]");

                    System.out.println("\nВычисление суммы элементов...");
                    sum = calculateSum(array);

                    System.out.println("\nРЕЗУЛЬТАТ");
                    System.out.println("Сумма элементов: " + sum);
                    System.out.println("(диапазон byte: от " + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + ")");

                    success = true;

                } catch (InputMismatchException e) {
                    System.out.println("\nОШИБКА ПЕРЕХВАЧЕНА (InputMismatchException)");
                    System.out.println("Тип ошибки: java.util.InputMismatchException");
                    System.out.println("Причина: Введена строка или символ вместо целого числа.");
                    System.out.println("Сообщение: " + e.toString());
                    System.out.println("Рекомендация: При следующем запуске вводите только целые числа.");

                } catch (ArithmeticException e) {
                    System.out.println("\n=== ОШИБКА ПЕРЕХВАЧЕНА (ArithmeticException) ===");
                    System.out.println("Тип ошибки: java.lang.ArithmeticException");
                    System.out.println("Причина: " + e.getMessage());
                    System.out.println("Рекомендация: Используйте массив меньшего размера или меньшие значения.");

                    if (array != null) {
                        System.out.println("\nИнформация для отладки:");
                        System.out.println("Размер массива: " + array.length);
                        System.out.print("Введённые элементы: ");
                        for (byte b : array) {
                            System.out.print(b + " ");
                        }
                        System.out.println();
                    }

                } finally {
                    System.out.println("Статус выполнения: " + (success ? "УСПЕШНО" : "С ОШИБКОЙ"));

                    if (success) {
                        System.out.println("Результат вычислений: " + sum);
                    } else {
                        System.out.println("Вычисление не было завершено из-за ошибки.");
                    }

                    scanner.close();
                    System.out.println("Ресурсы освобождены.");
                }

            }
        }