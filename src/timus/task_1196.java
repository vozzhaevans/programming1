package timus;

import java.io.*;
import java.util.Arrays;

public class task_1196 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] teacherList = new int[n];
        for (int i = 0; i < n; i++) {
            teacherList[i] = Integer.parseInt(reader.readLine());
        }

        int m = Integer.parseInt(reader.readLine());
        int[] studentList = new int[m];
        for (int i = 0; i < m; i++) {
            studentList[i] = Integer.parseInt(reader.readLine());
        }

        int matches = 0;
        for (int year : studentList) {
            if (Arrays.binarySearch(teacherList, year) >= 0) {
                matches++;
            }
        }

        System.out.println(matches);
    }
}