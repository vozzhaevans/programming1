package timus;

import java.io.*;
import java.util.*;

public class task_1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine());
        Team[] teams = new Team[n];

        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int id = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            teams[i] = new Team(id, m, i);
        }
        Arrays.sort(teams, (a, b) -> {
            if (a.m != b.m) {
                return Integer.compare(b.m, a.m);
            } else {
                return Integer.compare(a.originalIndex, b.originalIndex);
            }
        });
        for (Team team : teams) {
            writer.println(team.id + " " + team.m);
        }
        writer.flush();
    }

    static class Team {
        int id;
        int m;
        int originalIndex;

        Team(int id, int m, int originalIndex) {
            this.id = id;
            this.m = m;
            this.originalIndex = originalIndex;
        }
    }
}
