import java.util.*;

public class ShortestDistanceAfterQueries {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            graph.get(u).add(v);

            result[i] = bfsShortestPath(graph, n);
        }
        return result;
    }

    private int bfsShortestPath(List<List<Integer>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int neighbor : graph.get(city)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[city] + 1;
                    queue.offer(neighbor);

                    if (neighbor == n - 1) {
                        return dist[neighbor];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestDistanceAfterQueries afterQueries = new ShortestDistanceAfterQueries();

        // Test case 1
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        System.out.println(Arrays.toString(afterQueries.shortestDistanceAfterQueries(5, queries1)));  // Output: [3, 2, 1]

        // Test case 2
        int[][] queries2 = {{0, 3}, {0, 2}};
        System.out.println(Arrays.toString(afterQueries.shortestDistanceAfterQueries(4, queries2)));  // Output: [1, 1]
    }
}
