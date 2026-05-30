package timus;

import java.util.*;

public class task_1837 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> allPeople = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] team = sc.nextLine().split(" ");
            for (String member : team) {
                allPeople.add(member);
                graph.putIfAbsent(member, new HashSet<>());
            }
            for (int a = 0; a < 3; a++) {
                for (int b = a + 1; b < 3; b++) {
                    graph.get(team[a]).add(team[b]);
                    graph.get(team[b]).add(team[a]);
                }
            }
        }
        sc.close();

        Map<String, Integer> dist = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        String start = "Isenbaev";
        if (graph.containsKey(start)) {
            dist.put(start, 0);
            queue.add(start);
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String neighbor : graph.get(current)) {
                if (!dist.containsKey(neighbor)) {
                    dist.put(neighbor, dist.get(current) + 1);
                    queue.add(neighbor);
                }
            }
        }

        List<String> sorted = new ArrayList<>(allPeople);
        Collections.sort(sorted);

        for (String person : sorted) {
            System.out.print(person + " ");
            if (dist.containsKey(person)) {
                System.out.println(dist.get(person));
            } else {
                System.out.println("undefined");
            }
        }
    }
}
