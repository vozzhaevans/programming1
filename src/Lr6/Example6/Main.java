package Lr6.Example6;

import java.util.Arrays;

public class Main {
        public static void main(String[] args) {

            int[] arrayInt = new int [3];
            arrayInt[0] = 5;
            arrayInt[1] = 6;
            arrayInt[2] = 7;

            int[] arrayIntResult = Main.getArray(arrayInt, 2);
            System.out.println(Arrays.toString(arrayIntResult));

        }
        public static int[] getArray(int[] arrayInt, int value) {
            if (value>= arrayInt.length) {
                return arrayInt;
            }

            int[] arrayIntResult = new int[value];
            for (int i = 0; i < value; i++) {
                arrayIntResult[i] = arrayInt[i];
            }
            return arrayIntResult;

        }


}
